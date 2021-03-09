package org.jesperancinha.std.flash410;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;

@SpringBootApplication
@Profile("encode")
public class SpringFlash410Encoder implements CommandLineRunner {

    @Value("${flash410.password}")
    private String password;


    public static void main(String[] args) {
        SpringApplication.run(SpringFlash410Encoder.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        BLUE.printGenericLn(hashedPassword);
        System.exit(0);
    }
}
