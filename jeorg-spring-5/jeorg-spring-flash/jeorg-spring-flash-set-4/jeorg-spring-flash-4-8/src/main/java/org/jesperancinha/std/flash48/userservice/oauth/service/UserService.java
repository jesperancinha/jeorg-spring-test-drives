package org.jesperancinha.std.flash48.userservice.oauth.service;

import org.jesperancinha.std.flash48.userservice.oauth.domain.User;
import org.jesperancinha.std.flash48.userservice.oauth.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
