package org.jesperancinha.std.mastery2.portuguese.music.services;

import org.jesperancinha.std.mastery2.portuguese.music.api.ArtistService;
import org.jesperancinha.std.mastery2.portuguese.music.configuration.TestDatabaseConfiguration;
import org.jesperancinha.std.mastery2.portuguese.music.model.Artist;
import org.jesperancinha.std.mastery2.portuguese.music.repositories.ArtistRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@Transactional
@SpringBootTest
@ContextConfiguration
@Import(TestDatabaseConfiguration.class)
@ExtendWith(SpringExtension.class)
class ArtistServiceImplDbPopulatorTest {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private DatabasePopulator databasePopulator;

    @Autowired
    private DataSource dataSource;

    @Test
    void testListArtistsWithSQL_whenListAll_thenGetAList() throws SQLException {
        databasePopulator.populate(dataSource.getConnection());
        final var artists = artistService.listArtists();

        assertThat(artists).hasSize(4);
        final var actual = artists.get(0);
        assertThat(actual.getName()).isEqualTo("UHF");
        assertThat(actual.getNationality()).isEqualTo("Portuguese");
        final var actual2 = artists.get(1);
        assertThat(actual2.getName()).isEqualTo("Rádio Macau");
        assertThat(actual2.getNationality()).isEqualTo("Portuguese");
        final var actual3 = artists.get(2);
        assertThat(actual3.getName()).isEqualTo("Humanos");
        assertThat(actual3.getNationality()).isEqualTo("Portuguese");
        final var actual4 = artists.get(3);
        assertThat(actual4.getName()).isEqualTo("Mler Ife Dada");
        assertThat(actual4.getNationality()).isEqualTo("Portuguese");

    }
}