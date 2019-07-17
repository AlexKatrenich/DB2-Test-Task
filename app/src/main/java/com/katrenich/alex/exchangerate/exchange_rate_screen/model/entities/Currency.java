package com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities;

import java.util.Objects;

public class Currency {
    private String mShortName; // Example - USD
    private String mFullName; // Example - Долар США

    public Currency(String shortName) {
        mShortName = shortName;
    }

    public Currency(String shortName, String fullName) {
        mShortName = shortName;
        mFullName = fullName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return mShortName.equals(currency.mShortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mShortName);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "mShortName='" + mShortName + '\'' +
                '}';
    }
}
