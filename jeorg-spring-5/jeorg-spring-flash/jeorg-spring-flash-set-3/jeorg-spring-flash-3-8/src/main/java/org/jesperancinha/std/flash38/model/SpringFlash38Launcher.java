package org.jesperancinha.std.flash38.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class SpringFlash38Launcher {
    public static void main(String[] args) {
        SpringApplication.run(SpringFlash38Launcher.class, args);
    }
}