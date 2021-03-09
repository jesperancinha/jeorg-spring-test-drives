package org.jesperancinha.std.mastery1.french.music.configuration;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.mastery1.french.music.domain.Member;
import org.jesperancinha.std.mastery1.french.music.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
@PropertySource("classpath:extras.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "mastery1")
@Profile("!prod")
@Qualifier("mastery1Configuration")
public class Mastery11Configuration implements Mastery1Configuration {

    private String group;

    private List<String> members;

    private final MemberRepository memberRepository;

    public Mastery11Configuration(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostConstruct
    public void afterConfig() {
        resetAll();
        members.forEach(member -> {
            final Member member1 = new Member();
            member1.setName(member);
            final Member save = memberRepository.save(member1);
            ConsolerizerComposer.out(" ")
                    .magenta("Hi, I've just created")
                    .brightMagenta(save)
                    .magenta("for you!!")
                    .toConsoleLn();
        });
    }

    private void resetAll() {
        memberRepository.deleteAll();
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
