package com.steelzack.b2b2java8.utils;

import org.junit.Test;

import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by joaofilipesabinoesperancinha on 11-05-16.
 */
public class GregorianConversionTest {

    @Test
    public void convertGregorianCalendarDateFormatter() throws Exception {
        final GregorianConversion gregorianConversion = new GregorianConversion();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y M d VV m s H");
        GregorianCalendar result = gregorianConversion.convertGregorianCalendar("2016 05 1 Europe/London 01 01 01", formatter);
        assertThat(result.getTimeZone().getDisplayName(), equalTo("Greenwich Mean Time"));
        assertThat(result.toZonedDateTime().getYear(), equalTo(2016));
    }

    @Test
    public void convertGregorianCalendar() throws Exception {
        final GregorianConversion gregorianConversion = new GregorianConversion();
        GregorianCalendar result = gregorianConversion.convertGregorianCalendar("2016-05-11T01:15:40Z");
        assertThat(result.getTimeZone().getDisplayName(), equalTo("Coordinated Universal Time"));
        assertThat(result.toZonedDateTime().getYear(), equalTo(2016));
    }

}