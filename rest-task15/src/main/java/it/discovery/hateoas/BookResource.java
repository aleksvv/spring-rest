package it.discovery.hateoas;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import it.discovery.controller.BookController;
import it.discovery.model.Book;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Getter
@Setter
public class BookResource extends ResourceSupport {
    private final static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    private String name;

    private String author;

    @JsonProperty("id")
    private int bookId;

    private int year;

    private boolean rented;

    public BookResource(Book book) {
        mapper.map(book, this);
        add(linkTo(methodOn(BookController.class).findById(bookId)).withSelfRel());
        if (!rented) {
            add(linkTo(methodOn(BookController.class).rent(bookId)).withRel("rent"));
        }
    }
}
