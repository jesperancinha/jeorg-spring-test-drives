package org.jesperancinha.std.flash48.userservice;

import org.jesperancinha.std.flash48.userservice.oauth.domain.ApplicationUser;
import org.jesperancinha.std.flash48.userservice.oauth.service.UserService;
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
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringFlash48Launcher {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public SpringFlash48Launcher(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
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
        final ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setName(username);
        applicationUser.setPassword(passwordEncoder.encode(password));
        applicationUser.setEmail(email);
        applicationUser.setRole("ROLE_ADMIN");
        applicationUser.setDate(new Timestamp(LocalDateTime.now().toInstant(ZoneOffset.UTC).getNano()));
        userService.saveUser(applicationUser);
    }

    @GetMapping("/concerts")
    List<String> allConcerts() {
        return Arrays.asList(
                "Madonna - Holiday (Live Aid 1985)",
                "Queen - Radio Ga Ga (Live Aid 1985)"
        );
    }
}
