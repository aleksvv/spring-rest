package it.discovery.controller;

import it.discovery.RestApplication;
import it.discovery.model.Book;
import it.discovery.repository.BookRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitWebConfig(RestApplication.class)
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
public class BookControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookRepository bookRepository;

    @Test
    void findBookById_validId_returnsBook() throws Exception {
        Book book = new Book();
        book.setName("REST");
        book.setAuthor("Unknown");
        book.setYear(2018);

        given(bookRepository.findById(anyInt()))
                .willReturn(book);

        mockMvc.perform(get("/book/1").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.name", Matchers.equalTo("REST")));
    }
}
