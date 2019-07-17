package com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities;

import java.util.Date;

public class NbuExchangeRate extends BaseExchangeRate {
    private int value; // 1 = 0.001 currentCurrency to base currency

    public NbuExchangeRate(Currency baseCurrency, Currency secondaryCurrency, Date date) {
        super(baseCurrency, secondaryCurrency, date);
    }

    public NbuExchangeRate(Currency baseCurrency, Currency secondaryCurrency, Date date, int value) {
        super(baseCurrency, secondaryCurrency, date);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
