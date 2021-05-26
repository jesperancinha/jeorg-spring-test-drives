package org.jesperancinha.std.flash48.userservice.oauth.repository;

import org.jesperancinha.std.flash48.userservice.oauth.domain.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ApplicationUser, String> {

    ApplicationUser findUserByName(String name);
}