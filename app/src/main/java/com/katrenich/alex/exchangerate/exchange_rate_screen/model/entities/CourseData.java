package com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities;

import java.util.Locale;
import java.util.TimeZone;

public class CourseData {
    private long dateValue;
    private Locale locale;
    private TimeZone timeZone;

    public CourseData(long dateValue) {
        this.dateValue = dateValue;
    }

    public CourseData(long dateValue, Locale locale, TimeZone timeZone) {
        this.dateValue = dateValue;
        this.locale = locale;
        this.timeZone = timeZone;
    }

    public long getDateValue() {
        return dateValue;
    }

    public void setDateValue(long dateValue) {
        this.dateValue = dateValue;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        return "CourseData{" +
                "dateValue=" + dateValue +
                '}';
    }
}
