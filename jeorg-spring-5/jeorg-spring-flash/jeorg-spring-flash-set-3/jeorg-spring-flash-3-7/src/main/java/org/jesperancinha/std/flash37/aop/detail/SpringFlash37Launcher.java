package org.jesperancinha.std.flash37.aop.detail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class SpringFlash37Launcher {
    public static void main(String[] args) {
        SpringApplication.run(SpringFlash37Launcher.class, args);
    }
}