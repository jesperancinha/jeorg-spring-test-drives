package org.jesperancinha.std.mastery1.french.music.repository;

import org.jesperancinha.std.mastery1.french.music.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
