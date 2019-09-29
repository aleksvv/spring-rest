package it.discovery.repository;

import it.discovery.model.Book;
import it.discovery.model.Page;
import it.discovery.model.criteria.PageCriteria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class SimpleBookRepository implements BookRepository {
	private final Map<Integer, Book> books = new ConcurrentHashMap<>();

	private int counter = 0;

	@Override
	public Book findById(int id) {
		return books.get(id);
	}

	@Override
	public List<Book> findAll() {
		return new ArrayList<>(books.values());
	}

	@Override
	public Page search(PageCriteria pageCriteria) {
		int totalCount = books.size();
		List<Book> foundBooks = new ArrayList<Book>(books.values())
				.subList(pageCriteria.getPageIndex() * pageCriteria.getPageSize(),
						(pageCriteria.getPageIndex() + 1) * pageCriteria.getPageSize());
		return new Page(totalCount, foundBooks);
	}

	@Override
	public void save(Book book) {
		if (book.getId() == 0) {
			counter++;
			book.setId(counter);
			books.put(counter, book);
			System.out.println("*** Book with id=" + book.getId() + " was created");
		} else {
			books.put(book.getId(), book);
			System.out.println("*** Book with id=" + book.getId() + " was updated");
		}
	}

	@Override
	public boolean delete(int id) {
		if (!books.containsKey(id)) {
			return false;
		}

		books.remove(id);
		System.out.println("*** Book with id=" + id + " was deleted");
		return true;
	}

	@Override
	public boolean isEmpty() {
		return books.isEmpty();
	}

}
