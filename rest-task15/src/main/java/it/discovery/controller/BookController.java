package it.discovery.controller;

import io.micrometer.core.annotation.Timed;
import it.discovery.error.handling.BookNotFoundException;
import it.discovery.hateoas.BookResource;
import it.discovery.model.Book;
import it.discovery.model.Page;
import it.discovery.model.criteria.PageCriteria;
import it.discovery.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Timed("book.findAll")
    public ResponseEntity<List<Book>> findAll(@RequestParam int pageIndex, @RequestParam int size) {
        Page page = bookRepository.search(new PageCriteria(pageIndex, size));

        return ResponseEntity.ok().header("X-TOTAL-COUNT",
                String.valueOf(page.getTotalCount()))
                .body(page.getBooks());
    }

    @GetMapping("{id}")
    public BookResource findById(@PathVariable int id) {
        return Optional.ofNullable(bookRepository.findById(id))
                .map(BookResource::new)
                .orElseThrow(BookNotFoundException::new);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Book> save(@Valid @RequestBody Book book) {
        bookRepository.save(book);

        return ResponseEntity.created(URI.create("http://localhost:8080/book/" + book.getId()))
                .build();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        bookRepository.delete(id);
    }

}
