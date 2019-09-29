package it.discovery.actuator;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class MetricsComponent {
    private final Counter savedBooksCounter;

    public MetricsComponent(MeterRegistry meterRegistry) {
        savedBooksCounter = meterRegistry.counter("books.saved");
    }
}
