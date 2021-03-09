package org.jesperancinha.std.mastery1.french.music.controller;

import org.jesperancinha.std.mastery1.french.music.api.MemberService;
import org.jesperancinha.std.mastery1.french.music.domain.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping
    public @ResponseBody
    List<Member> getAllArtists() {
        return memberService.getAllMembers();
    }

    @RequestMapping("/search")
    public @ResponseBody
    List<Member> getAllArtists(
            @RequestParam
            final String param) {
        return memberService.getMembersLike(param);
    }

    @RequestMapping("/nonnull")
    public @ResponseBody
    List<Member> getNonNullArtists() {
        return memberService.getAllDateNonNullMembers();
    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody
    ResponseEntity<Object> deleteMemberById(
            @PathVariable
            final Long id) {
        memberService.deleteMemberById(id);
        return ResponseEntity.ok().build();
    }
}
