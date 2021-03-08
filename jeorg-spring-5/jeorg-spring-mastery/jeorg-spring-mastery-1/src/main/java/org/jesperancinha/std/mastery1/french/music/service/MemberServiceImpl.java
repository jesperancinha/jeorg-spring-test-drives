package org.jesperancinha.std.mastery1.french.music.service;

import org.jesperancinha.std.mastery1.french.music.api.MemberService;
import org.jesperancinha.std.mastery1.french.music.domain.Member;
import org.jesperancinha.std.mastery1.french.music.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getMembersLike(String param) {
        return memberRepository.findAllByNameLike(String.format("%%%s%%",param));
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
