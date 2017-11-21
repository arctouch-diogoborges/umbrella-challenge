package com.diogorborges.umbrella.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by diogoborges on 20/11/17.
 */


public class FCTTIME {

    @JsonProperty("year")
    private String year;

    @JsonProperty("mday")
    private String mday;

    @JsonProperty("yday")
    private String yday;

    @JsonProperty("civil")
    private String civil;

    @JsonProperty("month_name")
    private String monthName;

    @JsonProperty("weekday_name")
    private String weekdayName;

    public String getYear() {
        return year;
    }

    public String getMday() {
        return mday;
    }

    public String getYday() {
        return yday;
    }

    public String getCivil() {
        return civil;
    }

    public String getMonthName() {
        return monthName;
    }

    public String getWeekdayName() {
        return weekdayName;
    }

}
