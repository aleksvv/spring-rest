package it.discovery.controller;

import it.discovery.model.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {

    @GetMapping(value = "sample", produces = {
            MediaType.APPLICATION_JSON_UTF8_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public Book sampleBook() {
        Book book = new Book();
        book.setAuthor("Unknown");
        book.setName("Spring REST");
        return book;
    }
}
