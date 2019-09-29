package it.discovery.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BookSavedEvent {
    private final int bookId;
}
