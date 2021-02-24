package org.jesperancinha.std.flash12.cors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Flash12Controller {

    @GetMapping("/cors")
    @CrossOrigin(origins = "http://jeorg-spring-flash-12:8081")
    public String sentence() {
        return "When accessing from jeorg-spring-flash-12, there should be no blocking to visualizatin";
    }

    @GetMapping("/always")
    public String sentenceAlways() {
        return "This should be blocked from the opposite url.";
    }

    @GetMapping("/protected")
    public String sentenceProtected() {
        return "When accessing from jeorg-spring-flash-12, there should be no blocking to visualizatin";
    }


}