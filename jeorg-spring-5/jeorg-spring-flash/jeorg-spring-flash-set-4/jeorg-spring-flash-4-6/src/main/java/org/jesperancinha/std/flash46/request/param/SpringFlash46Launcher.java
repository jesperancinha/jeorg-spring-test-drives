package org.jesperancinha.std.flash46.request.param;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringFlash46Launcher {
    public static void main(String[] args) {
        SpringApplication.run(new Class[]{SpringFlash46Launcher.class}, args);
    }

    @GetMapping("/cats")
    public void showCat(@RequestParam CatType catType){
        switch (catType){

        }
    }
}
