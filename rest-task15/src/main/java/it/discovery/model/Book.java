package it.discovery.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.discovery.validation.BookTitleConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class Book {
    @PositiveOrZero
    private int id;

    @JsonProperty("title")
    @Size(min = 3, max = 80)
    private String author;

    @Size(min = 3, max = 128)
    @BookTitleConstraint
    private String name;

    @Min(1900)
    private int year;
}
