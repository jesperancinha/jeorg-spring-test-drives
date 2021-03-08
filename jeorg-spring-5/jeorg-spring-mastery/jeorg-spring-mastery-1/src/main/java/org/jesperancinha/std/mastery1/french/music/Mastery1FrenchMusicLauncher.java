package org.jesperancinha.std.mastery1.french.music;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.mastery1.french.music.domain.Member;
import org.jesperancinha.std.mastery1.french.music.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Mastery1FrenchMusicLauncher implements CommandLineRunner {

    private final MemberRepository memberRepository;

    public Mastery1FrenchMusicLauncher(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{Mastery1FrenchMusicLauncher.class}, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createMember("Celine Dion", 1981);
        createMember("Kate Ryan", 2001);
    }

    private void createMember(String s, int i) {
        final Member member = new Member();
        member.setName(s);
        member.setJoinDate(LocalDate.ofYearDay(i, 1));
        final Member save2 = memberRepository.save(member);
        ConsolerizerComposer
                .out(" ")
                .green("Creating artist")
                .magenta(save2)
                .green("...")
                .toConsoleLn();
    }
}