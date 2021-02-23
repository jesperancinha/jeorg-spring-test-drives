package org.jesperancinha.std.flash17.cipher.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashUserRepository extends JpaRepository<FlashUser, Long> {

    FlashUser getFlashUserByName(final String name);
}
