package it.discovery.controller;

import it.discovery.error.handling.BookNotFoundException;
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
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Book>> findAll(@RequestParam int pageIndex, @RequestParam int size) {
        Page page = bookRepository.search(new PageCriteria(pageIndex, size));

        return ResponseEntity.ok().header("X-TOTAL-COUNT",
                String.valueOf(page.getTotalCount()))
                .body(page.getBooks());
    }

    @GetMapping("{id}")
    public Book findById(@PathVariable int id) {
        return Optional.ofNullable(bookRepository.findById(id))
                .orElseThrow(BookNotFoundException::new);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody Book book) {
        bookRepository.save(book);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        bookRepository.delete(id);
    }

}
