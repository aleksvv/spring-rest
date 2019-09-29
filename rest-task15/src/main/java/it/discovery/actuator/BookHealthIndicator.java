package it.discovery.actuator;

import it.discovery.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookHealthIndicator implements HealthIndicator {

    private final BookRepository bookRepository;

    @Override
    public Health health() {
        if (bookRepository.isEmpty()) {
            return Health.down().withDetail("Reason", "Repository is empty").build();
        }
        return Health.up().build();
    }
}
