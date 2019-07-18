package com.katrenich.alex.exchangerate.exchange_rate_screen.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PBExchangeRates {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("bank")
    @Expose
    private String bank;
    @SerializedName("baseCurrency")
    @Expose
    private Integer baseCurrency;
    @SerializedName("baseCurrencyLit")
    @Expose
    private String baseCurrencyLit;
    @SerializedName("exchangeRate")
    @Expose
    private List<ExchangeRatePOJO> exchangeRatePOJO = null;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Integer getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(Integer baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getBaseCurrencyLit() {
        return baseCurrencyLit;
    }

    public void setBaseCurrencyLit(String baseCurrencyLit) {
        this.baseCurrencyLit = baseCurrencyLit;
    }

    public List<ExchangeRatePOJO> getExchangeRatePOJO() {
        return exchangeRatePOJO;
    }

    public void setExchangeRatePOJO(List<ExchangeRatePOJO> exchangeRatePOJO) {
        this.exchangeRatePOJO = exchangeRatePOJO;
    }

}
