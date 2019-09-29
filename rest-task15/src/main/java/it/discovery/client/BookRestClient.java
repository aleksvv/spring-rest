package it.discovery.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.discovery.model.Book;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookRestClient {

    private final RestTemplate restTemplate;

    private final ObjectMapper MAPPER = new ObjectMapper();

    public BookRestClient(String baseUrl) {
        restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
    }

    public List<Book> findAll() {
        List<Map<?, ?>> items = restTemplate.getForObject("", List.class);
        return items.stream()
                .map(book -> MAPPER.convertValue(book, Book.class))
                .collect(Collectors.toList());
    }

    public URI save(Book book) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        HttpEntity<Book> httpEntity = new HttpEntity<>(book, headers);
        return restTemplate.postForLocation("", httpEntity);
    }

    public static void main(String[] args) {
        BookRestClient client = new BookRestClient("http://localhost:8080/book");
        Book book = new Book();
        book.setName("REST");
        book.setAuthor("Unknown");
        book.setYear(2018);

        client.save(book);
        System.out.println(client.findAll());
    }
}
