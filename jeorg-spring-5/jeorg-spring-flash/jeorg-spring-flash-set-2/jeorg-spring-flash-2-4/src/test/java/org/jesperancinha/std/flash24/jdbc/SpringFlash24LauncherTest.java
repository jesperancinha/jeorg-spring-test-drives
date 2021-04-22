package org.jesperancinha.std.flash24.jdbc;

import org.jesperancinha.std.flash24.jdbc.template.Concert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringFlash24LauncherTest {

    @SpyBean
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SpringFlash24Launcher springFlash24Launcher;

    @Captor
    private ArgumentCaptor<RowMapper<Concert>> rowMapperArgumentCaptor;

    @Captor
    private ArgumentCaptor<String> stringArgumentCaptor;

    @Captor
    private ArgumentCaptor<AbstractFallbackSQLExceptionTranslator> abstractFallbackSQLExceptionTranslatorArgumentCaptor;

    @BeforeEach
    public void setUp() {
        springFlash24Launcher.initializeDatabase();
        final String[] concert1 = {"VH1 Divas Live", "New York's Beacon Theatre, US", LocalDateTime.of(1998, 4, 16, 0, 0, 0).toString()};
        final String[] concert2 = {"Lollapalooza 2012", "Chicago’s Grant Park, US", LocalDateTime.of(2012, 8, 12, 16, 0, 0).toString()};
        final List<Object[]> concerts = Arrays.asList(
                concert1, concert2
        );
        springFlash24Launcher.textCRUDCreate(concerts);
        Mockito.reset(jdbcTemplate);
    }

    @Test
    void testContext() {
    }

    @Test
    void testCRUDDelete_whenCalled_thenRemove1And2ButNot3() {
        final var concert1Id = springFlash24Launcher.testCRUDDelete(1);
        final var concert2Id = springFlash24Launcher.testCRUDDelete(2);
        final var concert3Id = springFlash24Launcher.testCRUDDelete(3);

        assertThat(concert1Id).isEqualTo(1);
        assertThat(concert2Id).isEqualTo(1);
        assertThat(concert3Id).isEqualTo(0);
    }

    @Test
    void testCRUDRead2_whenCalled_thenReadAsNormal() {
        final var concerts = springFlash24Launcher.testCRUDRead2();

        assertThat(concerts).isNotNull();
        assertThat(concerts).hasSize(2);
        final var concert1 = concerts.get(0);
        final var concert2 = concerts.get(1);
        assertThat(concert1.getName()).isEqualTo("VH1 Divas Live");
        assertThat(concert1.getVenue()).isEqualTo("New York's Beacon Theatre, US");
        assertThat(concert2.getName()).isEqualTo("Lollapalooza 2012");
        assertThat(concert2.getVenue()).isEqualTo("Chicago’s Grant Park, US");
        verify(jdbcTemplate, times(1)).query(stringArgumentCaptor.capture(), rowMapperArgumentCaptor.capture());
        final var rowMapperArgumentCaptorValue = rowMapperArgumentCaptor.getValue();
        assertThat(rowMapperArgumentCaptorValue).isNotNull();
        final var stringArgumentCaptorValue = stringArgumentCaptor.getValue();
        assertThat(stringArgumentCaptorValue).isNotNull();
        assertThat(stringArgumentCaptorValue).isEqualTo("select id, name, venue, local_date_time from concerts");
    }

    @Test
    void testCRUDUpdate_whenCalledWith2Records_thenUpdate2Records() {
        final String[] concert1Update = {"<HIDDEN1>", "New York's Beacon Theatre, US", LocalDateTime.of(1998, 4, 16, 0, 0, 0).toString(), "1"};
        final String[] concert2Update = {"<HIDDEN2>", "Chicago’s Grant Park, US", LocalDateTime.of(2012, 8, 12, 16, 0, 0).toString(), "2"};
        final List<Object[]> concertsUpdate = Arrays.asList(concert1Update, concert2Update);

        final int[] ints = springFlash24Launcher.testCRUDUpdate(concertsUpdate);
        final var concerts = springFlash24Launcher.testCRUDRead();

        for (int i : ints) {
            assertThat(ints[i]).isEqualTo(1);
        }
        assertThat(concerts).isNotNull();
        assertThat(concerts).hasSize(2);
        final var concert1 = concerts.get(0);
        final var concert2 = concerts.get(1);
        assertThat(concert1.getName()).isEqualTo("<HIDDEN1>");
        assertThat(concert1.getVenue()).isEqualTo("New York's Beacon Theatre, US");
        assertThat(concert2.getName()).isEqualTo("<HIDDEN2>");
        assertThat(concert2.getVenue()).isEqualTo("Chicago’s Grant Park, US");
        verify(jdbcTemplate, times(1)).query(stringArgumentCaptor.capture(), rowMapperArgumentCaptor.capture());
        final var rowMapperArgumentCaptorValue = rowMapperArgumentCaptor.getValue();
        assertThat(rowMapperArgumentCaptorValue).isNotNull();
        final var stringArgumentCaptorValue = stringArgumentCaptor.getValue();
        assertThat(stringArgumentCaptorValue).isNotNull();
        assertThat(stringArgumentCaptorValue).isEqualTo("select id, name, venue, local_date_time from concerts");
        verify(jdbcTemplate, times(1)).batchUpdate("UPDATE concerts set name = ?, venue = ?, local_date_time = ? WHERE id = ?", concertsUpdate);
    }

    @Test
    void testCRUDRead_whenCalled_thenReadAsNormal() {
        final var concerts = springFlash24Launcher.testCRUDRead();

        assertThat(concerts).isNotNull();
        assertThat(concerts).hasSize(2);
        final var concert1 = concerts.get(0);
        final var concert2 = concerts.get(1);
        assertThat(concert1.getName()).isEqualTo("VH1 Divas Live");
        assertThat(concert1.getVenue()).isEqualTo("New York's Beacon Theatre, US");
        assertThat(concert2.getName()).isEqualTo("Lollapalooza 2012");
        assertThat(concert2.getVenue()).isEqualTo("Chicago’s Grant Park, US");
        verify(jdbcTemplate, times(1)).query(stringArgumentCaptor.capture(), rowMapperArgumentCaptor.capture());
        final var rowMapperArgumentCaptorValue = rowMapperArgumentCaptor.getValue();
        assertThat(rowMapperArgumentCaptorValue).isNotNull();
        final var stringArgumentCaptorValue = stringArgumentCaptor.getValue();
        assertThat(stringArgumentCaptorValue).isNotNull();
        assertThat(stringArgumentCaptorValue).isEqualTo("select id, name, venue, local_date_time from concerts");
    }

    @Test
    void testCRUDCreate_whenCalledWith2Records_thenInsertTwoRecordsIndependently() {
        final String[] concert1 = {"VH1 Divas Live", "New York's Beacon Theatre, US", LocalDateTime.of(1998, 4, 16, 0, 0, 0).toString()};
        final String[] concert2 = {"Lollapalooza 2012", "Chicago’s Grant Park, US", LocalDateTime.of(2012, 8, 12, 16, 0, 0).toString()};
        final List<Object[]> concerts = Arrays.asList(
                concert1, concert2
        );
        final int[] ints = springFlash24Launcher.textCRUDCreate(concerts);

        verify(jdbcTemplate, times(1)).batchUpdate("insert into concerts(name, venue, local_date_time) values (?,?,?)", concerts);
        assertThat(ints).hasSize(2);
        for (int anInt : ints) {
            assertThat(anInt).isEqualTo(1);
        }
    }


    @Test
    void testException_whenDataAccessExceptionIsCustom_thenThrowEnrichedDataAccessException() {
        assertThrows(DataAccessException.class, () -> springFlash24Launcher.testException());

        verify(jdbcTemplate, times(1)).setExceptionTranslator(abstractFallbackSQLExceptionTranslatorArgumentCaptor.capture());
        verify(jdbcTemplate, times(1)).execute(stringArgumentCaptor.capture());
        final var abstractFallbackSQLExceptionTranslatorArgumentCaptorValue = abstractFallbackSQLExceptionTranslatorArgumentCaptor.getValue();
        assertThat(abstractFallbackSQLExceptionTranslatorArgumentCaptorValue).isNotNull();
        final String value = stringArgumentCaptor.getValue();
        assertThat(value).isEqualTo("This is not and will never be a query");
    }
}