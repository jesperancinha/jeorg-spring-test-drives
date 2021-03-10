package org.jesperancinha.std.mastery2.portuguese.music;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.mastery2.portuguese.music.model.Publisher;
import org.jesperancinha.std.mastery2.portuguese.music.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class Mastery2PortugueseMusicLauncher implements CommandLineRunner {

    private final PublisherRepository publisherRepository;

    public Mastery2PortugueseMusicLauncher(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{Mastery2PortugueseMusicLauncher.class}, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final var publisher1 = new Publisher();
        publisher1.setName("EMI");
        publisher1.setFoundationDate(LocalDate.of(1931, 3, 1));
        publisher1.setCity("London");

        final Publisher save = publisherRepository.save(publisher1);

        ConsolerizerComposer.out(" ")
                .brightRed("If you noticed we didn't configured any database!")
                .red("We just persisted this:")
                .newLine()
                .orange(save)
                .green("To check this, we will do a find all now.")
                .toConsoleLn();

        final List<Publisher> all = publisherRepository.findAll();

        ConsolerizerComposer.out(" ")
                .yellow("As you can see")
                .orange(all)
                .yellow("is in the database!")
                .toConsoleLn();


    }
}