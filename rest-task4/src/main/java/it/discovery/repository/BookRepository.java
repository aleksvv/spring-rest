package it.discovery.repository;

import it.discovery.model.Book;
import it.discovery.model.Page;
import it.discovery.model.criteria.PageCriteria;

import java.util.List;

public interface BookRepository {
	Book findById(int id);
	
	List<Book> findAll();

	Page search(PageCriteria pageCriteria);
	
	void save(Book book);
	
	boolean delete(int id);

	boolean isEmpty();

}
