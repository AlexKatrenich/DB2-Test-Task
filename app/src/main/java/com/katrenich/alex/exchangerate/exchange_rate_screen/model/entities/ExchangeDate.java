package com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities;

import java.util.Calendar;

public class ExchangeDate {
    private int year;
    private int month; // 01 = JANUARY
    private int dayOfMonth;

    public ExchangeDate(int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    // method transfers Calendar Month Constant to `month number of year`
    public static int transferMonthFromCalendar(int i) {
        return ++i;
    }

    public String getStringValue(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dayOfMonth < 10 ? "0" + dayOfMonth : String.valueOf(dayOfMonth));
        stringBuilder.append(".");
        stringBuilder.append(month < 10 ? "0" + month : String.valueOf(month));
        stringBuilder.append(".");
        stringBuilder.append(year);
        return stringBuilder.toString();
    }

    public String getStringValueForNbuAPI(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(year);
        stringBuilder.append(month < 10 ? "0" + month : String.valueOf(month));
        stringBuilder.append(dayOfMonth < 10 ? "0" + dayOfMonth : String.valueOf(dayOfMonth));
        return stringBuilder.toString();
    }

    public static ExchangeDate getCurrentDate(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = ExchangeDate.transferMonthFromCalendar(cal.get(Calendar.MONTH));
        int day = cal.get(Calendar.DAY_OF_MONTH);

        return new ExchangeDate(year, month, day);
    }

    @Override
    public String toString() {
        return "ExchangeDate{" +
                "year=" + year +
                ", month=" + month +
                ", dayOfMonth=" + dayOfMonth +
                '}';
    }
}
