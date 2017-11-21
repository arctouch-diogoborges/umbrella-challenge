package com.diogorborges.umbrella.util;

public class StringFormatter {

    public static String getFormattedDay(String weekdayName, String monthName, String mDay) {
        return String.format("%s, %s %s", weekdayName, monthName, mDay);
    }

}
