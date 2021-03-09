package org.jesperancinha.std.mastery1.french.music;

import org.jesperancinha.console.consolerizer.console.Consolerizer;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.mastery1.french.music.configuration.Mastery1Configuration;
import org.jesperancinha.std.mastery1.french.music.domain.Member;
import org.jesperancinha.std.mastery1.french.music.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@SpringBootApplication
public class Mastery1FrenchMusicLauncher implements CommandLineRunner {

    private final MemberRepository memberRepository;

    @Qualifier("mastery1Configuration")
    private final Mastery1Configuration mastery1Configuration;

    private final JdbcTemplate jdbcTemplate;

    public Mastery1FrenchMusicLauncher(MemberRepository memberRepository, Mastery1Configuration mastery1Configuration, JdbcTemplate jdbcTemplate) {
        this.memberRepository = memberRepository;
        this.mastery1Configuration = mastery1Configuration;
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{Mastery1FrenchMusicLauncher.class}, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createMember("Celine Dion", 1981);
        createMember("Kate Ryan", 2001);

        final List<Member> query = jdbcTemplate.query("select id, name, join_date from Member", new RowMapper<Member>() {
            @Override
            public Member mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
                final var member = new Member();
                member.setName(rs.getString("name"));
                final var joinDate = rs.getDate("join_date");
                if(Objects.nonNull(joinDate)) {
                    member.setJoinDate(joinDate.toLocalDate());
                }
                member.setId(rs.getLong("id"));

                ConsolerizerComposer.out(" ")
                        .orange("Performing select we get as record %d, the member:", rowNum)
                        .magenta(member)
                        .orange(", which is a very nice artist")
                        .toConsoleLn();
                return member;
            }
        });

        final var collect = query.stream().map(Objects::toString).collect(Collectors.joining("***"));
        Consolerizer.printRandomColorGeneric(collect);
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