package org.jesperancinha.std.flash17.cipher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringFlash17Launcher {

    private JdbcUserDetailsManager jdbcUserDetailsManager;

    private final PasswordEncoder passwordEncoder;

    public SpringFlash17Launcher(final JdbcUserDetailsManager jdbcUserDetailsManager, PasswordEncoder passwordEncoder) {
        this.jdbcUserDetailsManager = jdbcUserDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringFlash17Launcher.class, args);
    }


    @GetMapping("/open/create/{name}/{password}/{roles}")
    public void createUser(
            @PathVariable
                    String name,
            @PathVariable
                    String password,
            @PathVariable
                    String roles) {
        jdbcUserDetailsManager.createUser(User.withUsername(name).password(passwordEncoder.encode(password)).roles(roles).build());

    }
}
