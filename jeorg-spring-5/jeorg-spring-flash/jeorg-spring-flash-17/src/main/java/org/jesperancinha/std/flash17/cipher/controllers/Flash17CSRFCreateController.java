package org.jesperancinha.std.flash17.cipher.controllers;


import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.ORANGE;

@RestController
@Profile("test")
public class Flash17CSRFCreateController {

    private JdbcUserDetailsManager jdbcUserDetailsManager;

    private final PasswordEncoder passwordEncoder;

    public Flash17CSRFCreateController(final JdbcUserDetailsManager jdbcUserDetailsManager, PasswordEncoder passwordEncoder) {
        this.jdbcUserDetailsManager = jdbcUserDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/open/create/{name}/{password}/{role}")
    public void createUser(
            @PathVariable
                    String name,
            @PathVariable
                    String password,
            @PathVariable
                    String role
    ) {
        jdbcUserDetailsManager.createUser(User.withUsername(name).password(passwordEncoder.encode(password)).roles(role).build());
        BLUE.printGenericTitleLn("Received and created user via GET with CSRF protection active");
        ORANGE.printGenericLn("Name: %s", name);
        ORANGE.printGenericLn("Password: %s", password);
        ORANGE.printGenericLn("Role: %s", role);
    }
}
