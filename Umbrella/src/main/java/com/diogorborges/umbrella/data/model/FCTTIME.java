package com.diogorborges.umbrella.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "hour",
        "hour_padded",
        "min",
        "min_unpadded",
        "sec",
        "year",
        "mon",
        "mon_padded",
        "mon_abbrev",
        "mday",
        "mday_padded",
        "yday",
        "isdst",
        "epoch",
        "pretty",
        "civil",
        "month_name",
        "month_name_abbrev",
        "weekday_name",
        "weekday_name_night",
        "weekday_name_abbrev",
        "weekday_name_unlang",
        "weekday_name_night_unlang",
        "ampm",
        "tz",
        "age",
        "UTCDATE"
})
public class FCTTIME {

    @JsonProperty("hour")
    private String hour;
    @JsonProperty("hour_padded")
    private String hourPadded;
    @JsonProperty("min")
    private String min;
    @JsonProperty("min_unpadded")
    private String minUnpadded;
    @JsonProperty("sec")
    private String sec;
    @JsonProperty("year")
    private String year;
    @JsonProperty("mon")
    private String mon;
    @JsonProperty("mon_padded")
    private String monPadded;
    @JsonProperty("mon_abbrev")
    private String monAbbrev;
    @JsonProperty("mday")
    private String mday;
    @JsonProperty("mday_padded")
    private String mdayPadded;
    @JsonProperty("yday")
    private String yday;
    @JsonProperty("isdst")
    private String isdst;
    @JsonProperty("epoch")
    private String epoch;
    @JsonProperty("pretty")
    private String pretty;
    @JsonProperty("civil")
    private String civil;
    @JsonProperty("month_name")
    private String monthName;
    @JsonProperty("month_name_abbrev")
    private String monthNameAbbrev;
    @JsonProperty("weekday_name")
    private String weekdayName;
    @JsonProperty("weekday_name_night")
    private String weekdayNameNight;
    @JsonProperty("weekday_name_abbrev")
    private String weekdayNameAbbrev;
    @JsonProperty("weekday_name_unlang")
    private String weekdayNameUnlang;
    @JsonProperty("weekday_name_night_unlang")
    private String weekdayNameNightUnlang;
    @JsonProperty("ampm")
    private String ampm;
    @JsonProperty("tz")
    private String tz;
    @JsonProperty("age")
    private String age;
    @JsonProperty("UTCDATE")
    private String uTCDATE;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hour")
    public String getHour() {
        return hour;
    }

    @JsonProperty("hour")
    public void setHour(String hour) {
        this.hour = hour;
    }

    @JsonProperty("hour_padded")
    public String getHourPadded() {
        return hourPadded;
    }

    @JsonProperty("hour_padded")
    public void setHourPadded(String hourPadded) {
        this.hourPadded = hourPadded;
    }

    @JsonProperty("min")
    public String getMin() {
        return min;
    }

    @JsonProperty("min")
    public void setMin(String min) {
        this.min = min;
    }

    @JsonProperty("min_unpadded")
    public String getMinUnpadded() {
        return minUnpadded;
    }

    @JsonProperty("min_unpadded")
    public void setMinUnpadded(String minUnpadded) {
        this.minUnpadded = minUnpadded;
    }

    @JsonProperty("sec")
    public String getSec() {
        return sec;
    }

    @JsonProperty("sec")
    public void setSec(String sec) {
        this.sec = sec;
    }

    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("mon")
    public String getMon() {
        return mon;
    }

    @JsonProperty("mon")
    public void setMon(String mon) {
        this.mon = mon;
    }

    @JsonProperty("mon_padded")
    public String getMonPadded() {
        return monPadded;
    }

    @JsonProperty("mon_padded")
    public void setMonPadded(String monPadded) {
        this.monPadded = monPadded;
    }

    @JsonProperty("mon_abbrev")
    public String getMonAbbrev() {
        return monAbbrev;
    }

    @JsonProperty("mon_abbrev")
    public void setMonAbbrev(String monAbbrev) {
        this.monAbbrev = monAbbrev;
    }

    @JsonProperty("mday")
    public String getMday() {
        return mday;
    }

    @JsonProperty("mday")
    public void setMday(String mday) {
        this.mday = mday;
    }

    @JsonProperty("mday_padded")
    public String getMdayPadded() {
        return mdayPadded;
    }

    @JsonProperty("mday_padded")
    public void setMdayPadded(String mdayPadded) {
        this.mdayPadded = mdayPadded;
    }

    @JsonProperty("yday")
    public String getYday() {
        return yday;
    }

    @JsonProperty("yday")
    public void setYday(String yday) {
        this.yday = yday;
    }

    @JsonProperty("isdst")
    public String getIsdst() {
        return isdst;
    }

    @JsonProperty("isdst")
    public void setIsdst(String isdst) {
        this.isdst = isdst;
    }

    @JsonProperty("epoch")
    public String getEpoch() {
        return epoch;
    }

    @JsonProperty("epoch")
    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    @JsonProperty("pretty")
    public String getPretty() {
        return pretty;
    }

    @JsonProperty("pretty")
    public void setPretty(String pretty) {
        this.pretty = pretty;
    }

    @JsonProperty("civil")
    public String getCivil() {
        return civil;
    }

    @JsonProperty("civil")
    public void setCivil(String civil) {
        this.civil = civil;
    }

    @JsonProperty("month_name")
    public String getMonthName() {
        return monthName;
    }

    @JsonProperty("month_name")
    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    @JsonProperty("month_name_abbrev")
    public String getMonthNameAbbrev() {
        return monthNameAbbrev;
    }

    @JsonProperty("month_name_abbrev")
    public void setMonthNameAbbrev(String monthNameAbbrev) {
        this.monthNameAbbrev = monthNameAbbrev;
    }

    @JsonProperty("weekday_name")
    public String getWeekdayName() {
        return weekdayName;
    }

    @JsonProperty("weekday_name")
    public void setWeekdayName(String weekdayName) {
        this.weekdayName = weekdayName;
    }

    @JsonProperty("weekday_name_night")
    public String getWeekdayNameNight() {
        return weekdayNameNight;
    }

    @JsonProperty("weekday_name_night")
    public void setWeekdayNameNight(String weekdayNameNight) {
        this.weekdayNameNight = weekdayNameNight;
    }

    @JsonProperty("weekday_name_abbrev")
    public String getWeekdayNameAbbrev() {
        return weekdayNameAbbrev;
    }

    @JsonProperty("weekday_name_abbrev")
    public void setWeekdayNameAbbrev(String weekdayNameAbbrev) {
        this.weekdayNameAbbrev = weekdayNameAbbrev;
    }

    @JsonProperty("weekday_name_unlang")
    public String getWeekdayNameUnlang() {
        return weekdayNameUnlang;
    }

    @JsonProperty("weekday_name_unlang")
    public void setWeekdayNameUnlang(String weekdayNameUnlang) {
        this.weekdayNameUnlang = weekdayNameUnlang;
    }

    @JsonProperty("weekday_name_night_unlang")
    public String getWeekdayNameNightUnlang() {
        return weekdayNameNightUnlang;
    }

    @JsonProperty("weekday_name_night_unlang")
    public void setWeekdayNameNightUnlang(String weekdayNameNightUnlang) {
        this.weekdayNameNightUnlang = weekdayNameNightUnlang;
    }

    @JsonProperty("ampm")
    public String getAmpm() {
        return ampm;
    }

    @JsonProperty("ampm")
    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    @JsonProperty("tz")
    public String getTz() {
        return tz;
    }

    @JsonProperty("tz")
    public void setTz(String tz) {
        this.tz = tz;
    }

    @JsonProperty("age")
    public String getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(String age) {
        this.age = age;
    }

    @JsonProperty("UTCDATE")
    public String getUTCDATE() {
        return uTCDATE;
    }

    @JsonProperty("UTCDATE")
    public void setUTCDATE(String uTCDATE) {
        this.uTCDATE = uTCDATE;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
