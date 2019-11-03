package org.jesperancinha.b2b2java8.utils;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by joaofilipesabinoesperancinha on 11-05-16.
 */
public class GregorianConversionTest {

    @Test
    public void convertGregorianCalendarDateFormatter() throws Exception {
        final GregorianConversion gregorianConversion = new GregorianConversion();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y M d VV m s H");
        GregorianCalendar result = gregorianConversion.convertGregorianCalendar("2016 05 1 Europe/London 01 01 01", formatter);
        assertThat(result.getTimeZone().getDisplayName()).isIn("Greenwich Mean Time", "Mittlere Greenwich-Zeit");
        assertThat(result.toZonedDateTime().getYear()).isEqualTo(2016);
    }

    @Test
    public void convertGregorianCalendar() throws Exception {
        final GregorianConversion gregorianConversion = new GregorianConversion();
        GregorianCalendar result = gregorianConversion.convertGregorianCalendar("2016-05-11T01:15:40Z");
        assertThat(result.getTimeZone().getDisplayName()).isIn("Coordinated Universal Time", "Koordinierte Weltzeit");
        assertThat(result.toZonedDateTime().getYear()).isEqualTo(2016);
    }

}