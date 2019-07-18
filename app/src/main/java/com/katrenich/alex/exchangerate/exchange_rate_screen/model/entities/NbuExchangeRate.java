package com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities;


public class NbuExchangeRate extends BaseExchangeRate {
    private int value; // 1 = 0.001 currentCurrency to base currency

    public NbuExchangeRate(Currency baseCurrency, Currency currentCurrency) {
        super(baseCurrency, currentCurrency);
    }

    public NbuExchangeRate(Currency baseCurrency, Currency secondaryCurrency, int value) {
        super(baseCurrency, secondaryCurrency);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
