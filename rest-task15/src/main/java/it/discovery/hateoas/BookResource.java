package it.discovery.hateoas;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.discovery.controller.BookController;
import it.discovery.model.Book;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Getter
public class BookResource extends ResourceSupport {
    private String name;

    private String author;

    @JsonProperty("id")
    private int bookId;

    private int year;

    private boolean rented;

    public BookResource(Book book) {
        name = book.getName();
        author = book.getAuthor();
        bookId = book.getId();
        year = book.getYear();
        rented = book.isRented();
        add(linkTo(methodOn(BookController.class).findById(bookId)).withSelfRel());
        if (!rented) {
            add(linkTo(methodOn(BookController.class).rent(bookId)).withRel("rent"));
        }
    }
}
