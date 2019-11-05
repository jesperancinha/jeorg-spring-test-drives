package org.jesperancinha.b2b2java8.utils;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.LocalDate;

import static java.time.DayOfWeek.MONDAY;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jesperancinha on 12-5-16.
 */
public class DateTest {

    @Test
    public void getStartOfCurrentYearLastWeek_2016() {
        final LocalDate testDate = LocalDate.of(2016, 1, 1);
        final LocalDate result = Date.getStartOfCurrentYearLastWeek(testDate);
        assertThat(result.getDayOfYear()).isEqualTo(361);
        assertThat(result.getDayOfWeek()).isEqualTo(MONDAY);
        assertThat(result.getYear()).isEqualTo(2016);
    }

    @Test
    public void getStartOfCurrentYearLastWeek_2015() {
        final LocalDate testDate = LocalDate.of(2015, 1, 1);
        final LocalDate result = Date.getStartOfCurrentYearLastWeek(testDate);
        assertThat(result.getDayOfYear()).isEqualTo(362);
        assertThat(result.getDayOfWeek()).isEqualTo(MONDAY);
        assertThat(result.getYear()).isEqualTo(2015);
    }

    @Test
    public void getStartOfCurrentYearLastWeek_2014() {
        final LocalDate testDate = LocalDate.of(2014, 1, 1);
        final LocalDate result = Date.getStartOfCurrentYearLastWeek(testDate);
        assertThat(result.getDayOfYear()).isEqualTo(363);
        assertThat(result.getDayOfWeek()).isEqualTo(MONDAY);
        assertThat(result.getYear()).isEqualTo(2014);
        assertThat(result.getDayOfMonth()).isEqualTo(29);
    }

    @Test
    public void getStartOfCurrentYearLastWeek_2016_On_A_Monday() {
        final LocalDate testDate = LocalDate.of(2016, 5, 9);
        final LocalDate result = Date.getStartOfCurrentYearLastWeek(testDate);
        assertThat(result.getDayOfYear()).isEqualTo(361);
        assertThat(result.getDayOfWeek()).isEqualTo(MONDAY);
        assertThat(result.getYear()).isEqualTo(2016);
    }


    @Test
    public void fromDateToDateSimple() throws ParseException {
        final String inputDate = "2016-05-12-21+42+21+123456";

        final String result = Date.fromDateToMicrosecondsDateSimple(inputDate);

        assertThat(result).isEqualTo("000456");
    }

    @Test
    public void fromDateToDate() {
        final String inputDate = "2016-05-12-21+42+21+123456";

        final String result = Date.fromDateToMicrosecondsDate(inputDate);

        assertThat(result).isEqualTo("123456");
    }

}
