package org.jesperancinha.std.flash510.bean.initialization;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class SpringFlash510Launcher implements CommandLineRunner {

    public static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        SpringApplication.run(SpringFlash510Launcher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
