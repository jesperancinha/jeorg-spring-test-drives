package org.jesperancinha.b2b2java8.utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;

/**
 * Created by joaofilipesabinoesperancinha on 11-05-16.
 */
public class GregorianConversion {
    public GregorianCalendar convertGregorianCalendar(String dateToParse) {
        final GregorianCalendar calDate = GregorianCalendar.from(ZonedDateTime.parse(dateToParse));
        return calDate;
    }

    public GregorianCalendar convertGregorianCalendar(String dateToParse, DateTimeFormatter formatter) {
        final GregorianCalendar calDate = GregorianCalendar.from(ZonedDateTime.parse(dateToParse, formatter));
        return calDate;
    }
}
