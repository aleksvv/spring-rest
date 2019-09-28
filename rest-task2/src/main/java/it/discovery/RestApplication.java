package it.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
@RestController
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @RequestMapping("time")
    public String currentTime() {
        return LocalTime.now().toString();
    }

    @RequestMapping("date")
    public String currentDate() {
        return LocalDate.now().toString();
    }
}
