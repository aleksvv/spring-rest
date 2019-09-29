package it.discovery.actuator;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import it.discovery.event.BookSavedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MetricsComponent {
    private final Counter savedBooksCounter;

    public MetricsComponent(MeterRegistry meterRegistry) {
        savedBooksCounter = meterRegistry.counter("books.saved");
    }

    @EventListener
    public void onBookSaved(BookSavedEvent event) {
        savedBooksCounter.increment();
    }
}
