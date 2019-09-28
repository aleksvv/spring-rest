package it.discovery.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement
public class Book {
	private int id;

	private String author;

	private String name;
	
	private int year;
}
