package it.discovery.controller;

import it.discovery.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {

    @GetMapping("sample")
    public Book sampleBook() {
        Book book = new Book();
        book.setAuthor("Unknown");
        book.setName("Spring REST");
        return book;
    }
}
