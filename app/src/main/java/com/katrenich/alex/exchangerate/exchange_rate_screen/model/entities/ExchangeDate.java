package com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities;

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
    public static int transferMnthFromCalendar(int i) {
        return ++i;
    }

    public String getStringValue(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dayOfMonth > 9 ? "0" + dayOfMonth : String.valueOf(dayOfMonth));
        stringBuilder.append(".");
        stringBuilder.append(month > 9 ? "0" + month : String.valueOf(month));
        stringBuilder.append(".");
        stringBuilder.append(year);
        return stringBuilder.toString();
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
