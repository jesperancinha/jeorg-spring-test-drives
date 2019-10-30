package com.steelzack.b2b2java8.utils;

import static java.time.DayOfWeek.MONDAY;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by jesperancinha on 12-5-16.
 */
public class Date {

    private static final DateTimeFormatter FROM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH+mm+ss+SSSSSS");
    private static final DateTimeFormatter TO_FORMATTER = DateTimeFormatter.ofPattern("SSSSSS");

    private static final SimpleDateFormat FROM_SIMPLE = new SimpleDateFormat("yyyy-MM-dd-HH+mm+ss+SSSSSS");
    private static final SimpleDateFormat TO_SIMPLE = new SimpleDateFormat("SSSSSS");

    public static String fromDateToMicrosecondsDate(String srcDate) {
        return TO_FORMATTER.format(FROM_FORMATTER.parse(srcDate));
    }

    public static String fromDateToMicrosecondsDateSimple(String srcDate) throws ParseException {
        return TO_SIMPLE.format(FROM_SIMPLE.parse(srcDate));
    }

    public static LocalDate getStartOfCurrentYearLastWeek(LocalDate currentDate) {
        return currentDate.with(TemporalAdjusters.lastDayOfYear()).with(TemporalAdjusters.previousOrSame(MONDAY));
    }

}
