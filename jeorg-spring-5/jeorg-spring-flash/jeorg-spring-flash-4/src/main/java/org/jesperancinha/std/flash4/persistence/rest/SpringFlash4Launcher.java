package org.jesperancinha.std.flash4.persistence.rest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BRIGHT_MAGENTA;
import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@RestController
public class SpringFlash4Launcher {
    public static void main(String[] args) {
        run(SpringFlash4Launcher.class, args);
    }

    @PostMapping(path = "/",
            consumes = "application/text",
            headers = "currentTime")
    public void currentDate(
            @RequestHeader("currentTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate localDate) {
        BRIGHT_MAGENTA.printGenericTitleLn(localDate);
    }

    @PostMapping(path = "/time",
            consumes = "application/text",
            headers = "currentTime")
    public void currentTime(
            @RequestHeader("currentTime")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                    LocalDateTime localDateTime) {
        BRIGHT_MAGENTA.printGenericTitleLn(localDateTime);
    }
}
