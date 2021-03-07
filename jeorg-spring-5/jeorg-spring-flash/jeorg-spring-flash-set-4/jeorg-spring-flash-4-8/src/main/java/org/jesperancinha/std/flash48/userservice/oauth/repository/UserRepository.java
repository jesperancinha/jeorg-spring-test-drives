package org.jesperancinha.std.flash48.userservice.oauth.repository;

import org.jesperancinha.std.flash48.userservice.oauth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findUserByName(String name);
}