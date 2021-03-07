package org.jesperancinha.std.flash48.userservice.oauth.config;

import org.jesperancinha.std.flash48.userservice.oauth.domain.User;
import org.jesperancinha.std.flash48.userservice.oauth.repository.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
@Primary
public class Flash48AuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public Flash48AuthenticationProvider(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        if (authentication.getName() == null || authentication.getCredentials() == null) {
            return null;
        }
        if (authentication.getName()
                .isEmpty() || authentication.getCredentials()
                .toString()
                .isEmpty()) {
            return null;
        }
        final Optional<User> appUser = this.userRepository.findById(authentication.getName());

        if (appUser.isPresent()) {
            final User user = appUser.get();
            final String providedUser = authentication.getName();
            final String providedUserPassword = (String) authentication.getCredentials();
            if (providedUser.equalsIgnoreCase(user.getName()) && passwordEncoder.matches(providedUserPassword, user.getPassword())) {
                return new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.getRole())));
            }
        }

        throw new UsernameNotFoundException("Invalid username/password.");
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
