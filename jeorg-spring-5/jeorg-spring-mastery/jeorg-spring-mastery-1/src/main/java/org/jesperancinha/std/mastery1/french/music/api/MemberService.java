package org.jesperancinha.std.mastery1.french.music.api;

import org.jesperancinha.std.mastery1.french.music.domain.Member;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberService {
    List<Member> getMembersLike(String param);

    List<Member> getAllMembers();

    void deleteMemberById(Long id);

    List<Member> getAllDateNonNullMembers();
}
