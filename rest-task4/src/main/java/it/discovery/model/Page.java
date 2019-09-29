package it.discovery.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Page {
    private final int totalCount;

    private final List<Book> books;
}
