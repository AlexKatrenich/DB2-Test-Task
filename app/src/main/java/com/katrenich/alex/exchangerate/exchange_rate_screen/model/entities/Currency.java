package com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities;

import java.util.Date;
import java.util.Objects;

public class Currency {
    private String mShortName; // Example - USD
    private String mFullName; // Example - Долар США
    private int mValue; // 1 = 0.001
    private Date mDate;

    public Currency(String shortName) {
        mShortName = shortName;
    }

    public Currency(String shortName, int value) {
        mShortName = shortName;
        mValue = value;
    }

    public Currency(String shortName, String fullName, int value, Date date) {
        mShortName = shortName;
        mFullName = fullName;
        mValue = value;
        mDate = date;
    }

    public String getShortName() {
        return mShortName;
    }

    public void setShortName(String shortName) {
        mShortName = shortName;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public int getValue() {
        return mValue;
    }

    public void setValue(int value) {
        mValue = value;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return mValue == currency.mValue &&
                mShortName.equals(currency.mShortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mShortName, mValue);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "mShortName='" + mShortName + '\'' +
                '}';
    }
}
