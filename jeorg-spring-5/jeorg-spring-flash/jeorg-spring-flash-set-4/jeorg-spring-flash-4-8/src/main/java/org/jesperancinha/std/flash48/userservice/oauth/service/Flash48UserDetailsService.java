package org.jesperancinha.std.flash48.userservice.oauth.service;

import org.jesperancinha.std.flash48.userservice.oauth.domain.ApplicationUser;
import org.jesperancinha.std.flash48.userservice.oauth.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class Flash48UserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public Flash48UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final Optional<ApplicationUser> userEntity = userRepository.findById(username);

        if (userEntity.isPresent()) {
            final ApplicationUser applicationUser = userEntity.get();
            return createUserDetails(applicationUser);
        }

        return null;
    }

    private User createUserDetails(ApplicationUser applicationUser) {
        return new User(
                applicationUser.getEmail(),
                applicationUser.getPassword(),
                Collections.singletonList(
                        new SimpleGrantedAuthority(
                                applicationUser.getRole())));
    }

}