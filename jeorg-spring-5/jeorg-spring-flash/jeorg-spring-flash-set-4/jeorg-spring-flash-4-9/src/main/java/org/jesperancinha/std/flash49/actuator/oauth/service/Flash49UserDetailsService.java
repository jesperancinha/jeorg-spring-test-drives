package org.jesperancinha.std.flash49.actuator.oauth.service;

import org.jesperancinha.std.flash49.actuator.oauth.domain.User;
import org.jesperancinha.std.flash49.actuator.oauth.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class Flash49UserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public Flash49UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final Optional<User> userEntity = userRepository.findById(username);

        if (userEntity.isPresent()) {
            final User user = userEntity.get();
            return createUserDetails(user);
        }

        return null;
    }

    private org.springframework.security.core.userdetails.User createUserDetails(User user) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
    }

}