package org.jesperancinha.std.flash4.persistence.rest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
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
    public LocalDate currentDate(
            @RequestHeader("currentTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate localDate) {
        BRIGHT_MAGENTA.printGenericTitleLn(localDate);
        return localDate;
    }

    @PostMapping(path = "/time",
            consumes = "application/text",
            headers = "currentTime")
    public LocalDateTime currentTime(
            @RequestHeader("currentTime")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                    LocalDateTime localDateTime) {
        BRIGHT_MAGENTA.printGenericTitleLn(localDateTime);
        return localDateTime;
    }

    @PostMapping(
            path = "/dollars",
            consumes = "application/text",
            headers = "dollars")
    public BigDecimal thousandDollars(
            @RequestHeader("dollars")
            @NumberFormat(style = NumberFormat.Style.NUMBER,
                    pattern = "$###,###.###")
                    BigDecimal dollars) {
        MAGENTA.printGenericTitleLn(dollars);
        return dollars;
    }
}
