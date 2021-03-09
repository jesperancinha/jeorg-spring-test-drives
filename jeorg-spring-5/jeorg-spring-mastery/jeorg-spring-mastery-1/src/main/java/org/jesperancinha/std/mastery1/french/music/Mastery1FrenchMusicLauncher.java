package org.jesperancinha.std.mastery1.french.music;

import org.apache.logging.log4j.core.impl.MementoMessage;
import org.jesperancinha.console.consolerizer.console.Consolerizer;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.mastery1.french.music.configuration.Mastery1Configuration;
import org.jesperancinha.std.mastery1.french.music.domain.Artist;
import org.jesperancinha.std.mastery1.french.music.domain.Member;
import org.jesperancinha.std.mastery1.french.music.repository.ArtistRepository;
import org.jesperancinha.std.mastery1.french.music.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class Mastery1FrenchMusicLauncher implements CommandLineRunner {

    private final MemberRepository memberRepository;

    private final ArtistRepository artistRepository;

    private final EntityManager entityManager;
    @Qualifier("mastery1Configuration")
    private final Mastery1Configuration mastery1Configuration;

    private final JdbcTemplate jdbcTemplate;

    public Mastery1FrenchMusicLauncher(MemberRepository memberRepository, ArtistRepository artistRepository, EntityManager entityManager, Mastery1Configuration mastery1Configuration, JdbcTemplate jdbcTemplate) {
        this.memberRepository = memberRepository;
        this.artistRepository = artistRepository;
        this.entityManager = entityManager;
        this.mastery1Configuration = mastery1Configuration;
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{Mastery1FrenchMusicLauncher.class}, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        final Member celineDion = createMember("Celine Dion", 1981);
        createMember("Kate Ryan", 2001);

        final var artist = new Artist();
        artist.setName("Celine Dion");
        artist.setFoundationDate(LocalDate.ofYearDay(1981,1));
        artist.setMemberList(Collections.singletonList(celineDion));
        final Artist save = artistRepository.save(artist);
        ConsolerizerComposer.out(" ")
                .yellow("We have created this artist")
                .orange(save)
                .yellow(". It's a good artist!")
                .toConsoleLn();

        final Member member = entityManager.getReference(Member.class, 1L);
        final var artist2 = new Artist();
        artist2.setMemberList(Collections.singletonList(member));
        artistRepository.save(artist2);
        ConsolerizerComposer.out(" ")
                .red("This time we did not need to read the database.")
                .newLine()
                .brightRed("Instead, we get a proxy object.")
                .red("This is a JDK proxy object, which we can use.")
                .brightRed("Our artist is saved")
                .newLine()
                .red("In order to check if the changes went well, we should just read our database again")
                .toConsoleLn();
        final Artist byId = artistRepository.findById(save.getId() + 1).orElse(null);
        ConsolerizerComposer.out(" ")
                .blue("And so our result ends up being")
                .cyan(byId)
                .toConsoleLn();

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

    private Member createMember(String s, int i) {
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
        return save2;
    }
}