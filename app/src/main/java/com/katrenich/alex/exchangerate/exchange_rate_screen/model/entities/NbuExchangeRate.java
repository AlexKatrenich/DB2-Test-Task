package com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities;


public class NbuExchangeRate extends BaseExchangeRate {
    private int value; // 1 = 0.001 currentCurrency to base currency

    public NbuExchangeRate(Currency baseCurrency, Currency currentCurrency) {
        super(baseCurrency, currentCurrency);
    }

    public NbuExchangeRate(Currency baseCurrency, Currency secondaryCurrency, ExchangeDate date) {
        super(baseCurrency, secondaryCurrency, date);
    }

    public NbuExchangeRate(Currency baseCurrency, Currency secondaryCurrency, ExchangeDate date, int value) {
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
