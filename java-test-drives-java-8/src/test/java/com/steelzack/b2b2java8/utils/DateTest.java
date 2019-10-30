package com.steelzack.b2b2java8.utils;

import static java.time.DayOfWeek.MONDAY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.time.LocalDate;

import org.junit.Test;

/**
 * Created by jesperancinha on 12-5-16.
 */
public class DateTest {

    @Test
    public void getStartOfCurrentYearLastWeek_2016() throws Exception {
        final LocalDate testDate = LocalDate.of(2016, 1, 1);
        final LocalDate result = Date.getStartOfCurrentYearLastWeek(testDate);
        assertThat(result.getDayOfYear(), equalTo(361));
        assertThat(result.getDayOfWeek(), equalTo(MONDAY));
        assertThat(result.getYear(), equalTo(2016));
    }

    @Test
    public void getStartOfCurrentYearLastWeek_2015() throws Exception {
        final LocalDate testDate = LocalDate.of(2015, 1, 1);
        final LocalDate result = Date.getStartOfCurrentYearLastWeek(testDate);
        assertThat(result.getDayOfYear(), equalTo(362));
        assertThat(result.getDayOfWeek(), equalTo(MONDAY));
        assertThat(result.getYear(), equalTo(2015));
    }

    @Test
    public void getStartOfCurrentYearLastWeek_2014() throws Exception {
        final LocalDate testDate = LocalDate.of(2014, 1, 1);
        final LocalDate result = Date.getStartOfCurrentYearLastWeek(testDate);
        assertThat(result.getDayOfYear(), equalTo(363));
        assertThat(result.getDayOfWeek(), equalTo(MONDAY));
        assertThat(result.getYear(), equalTo(2014));
        assertThat(result.getDayOfMonth(), equalTo(29));
    }

    @Test
    public void getStartOfCurrentYearLastWeek_2016_On_A_Monday() throws Exception {
        final LocalDate testDate = LocalDate.of(2016, 5, 9);
        final LocalDate result = Date.getStartOfCurrentYearLastWeek(testDate);
        assertThat(result.getDayOfYear(), equalTo(361));
        assertThat(result.getDayOfWeek(), equalTo(MONDAY));
        assertThat(result.getYear(), equalTo(2016));
    }


    @Test
    public void fromDateToDateSimple() throws Exception {
        final String inputDate = "2016-05-12-21+42+21+123456";

        final String result = Date.fromDateToMicrosecondsDateSimple(inputDate);

        assertThat(result, equalTo("000456"));
    }

    @Test
    public void fromDateToDate() throws Exception {
        final String inputDate = "2016-05-12-21+42+21+123456";

        final String result = Date.fromDateToMicrosecondsDate(inputDate);

        assertThat(result, equalTo("123456"));
    }

}
