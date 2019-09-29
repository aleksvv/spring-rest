package it.discovery.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.discovery.RestApplication;
import it.discovery.model.Book;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig(RestApplication.class)
@AutoConfigureMockMvc
public class BookControllerTest {
    @Autowired
    MockMvc mockMvc;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    void saveBook_validObject_returnsLocation() throws Exception {
        Book book = new Book();
        book.setName("REST");
        book.setAuthor("Unknown");
        book.setYear(2018);

        mockMvc.perform(post("/book").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(MAPPER.writeValueAsBytes(book)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", Matchers.notNullValue()));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1000, 1899})
    void saveBook_incorrectYear_badRequest(int year) throws Exception {
        Book book = new Book();
        book.setName("REST");
        book.setAuthor("Unknown");
        book.setYear(year);

        mockMvc.perform(post("/book").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(MAPPER.writeValueAsBytes(book)))
                .andExpect(status().isBadRequest());
    }

}

