package com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities;


public class PbExchangeRate extends BaseExchangeRate {
    private int saleValue; // 1 = 0.001 currentCurrency to base currency
    private int buyValue; // 1 = 0.001 currentCurrency to base currency

    public PbExchangeRate(Currency baseCurrency, Currency currentCurrency) {
        super(baseCurrency, currentCurrency);
    }

    public PbExchangeRate(Currency baseCurrency, Currency currentCurrency, int saleValue, int buyValue) {
        super(baseCurrency, currentCurrency);
        this.saleValue = saleValue;
        this.buyValue = buyValue;
    }

    public int getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(int saleValue) {
        this.saleValue = saleValue;
    }

    public int getBuyValue() {
        return buyValue;
    }

    public void setBuyValue(int buyValue) {
        this.buyValue = buyValue;
    }

}
