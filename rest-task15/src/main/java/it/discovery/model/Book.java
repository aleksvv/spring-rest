package it.discovery.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
	private int id;

	private String author;

	private String name;
	
	private int year;
}
