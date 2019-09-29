package it.discovery.advice;

import it.discovery.model.Book;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class BookResponseAdvice implements ResponseBodyAdvice<Book> {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return returnType.getMethod().getReturnType() == Book.class;
    }

    @Override
    public Book beforeBodyWrite(Book body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return body;
    }
}
