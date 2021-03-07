package org.jesperancinha.std.flash48.userservice;

import org.jesperancinha.std.flash48.userservice.oauth.domain.User;
import org.jesperancinha.std.flash48.userservice.oauth.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@SpringBootApplication
@RestController
public class SpringFlash48Launcher {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public SpringFlash48Launcher(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{SpringFlash48Launcher.class}, args);
    }

    @GetMapping(path = "/open")
    public @ResponseBody
    String encode(
            @RequestParam
                    String encode) {
        return passwordEncoder.encode(encode);
    }

    @PostMapping(path = "/open/create")
    public void createUser(
            @RequestHeader
                    String username,
            @RequestHeader
                    String password,
            @RequestHeader(required = false)
                    String email) {
        final User user = new User();
        user.setName(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setRole("ROLE_ADMIN");
        user.setDate(new Timestamp(LocalDateTime.now().toInstant(ZoneOffset.UTC).getNano()));
        userRepository.save(user);
    }
}
