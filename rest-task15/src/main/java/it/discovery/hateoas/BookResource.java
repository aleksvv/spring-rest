package it.discovery.hateoas;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.discovery.model.Book;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

@Getter
public class BookResource extends ResourceSupport {
    private String name;

    private String author;

    @JsonProperty("id")
    private int bookId;

    private int year;

    public BookResource(Book book) {
        name = book.getName();
        author = book.getAuthor();
        bookId = book.getId();
        year = book.getYear();
    }
}
