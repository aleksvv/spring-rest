package it.discovery;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("current")
public class UtilController {

    @RequestMapping("time")
    public String currentTime() {
        return LocalTime.now().toString();
    }

    @RequestMapping("date")
    public String currentDate() {
        return LocalDate.now().toString();
    }
}
