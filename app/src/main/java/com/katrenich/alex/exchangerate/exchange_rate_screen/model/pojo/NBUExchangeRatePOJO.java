package com.katrenich.alex.exchangerate.exchange_rate_screen.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NBUExchangeRatePOJO {

    @SerializedName("txt")
    @Expose
    private String currencyFullName;

    @SerializedName("rate")
    @Expose
    private Double rate;

    @SerializedName("cc")
    @Expose
    private String currencyShortName;

    public String getCurrencyFullName() {
        return currencyFullName;
    }

    public void setCurrencyFullName(String currencyFullName) {
        this.currencyFullName = currencyFullName;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getCurrencyShortName() {
        return currencyShortName;
    }

    public void setCurrencyShortName(String currencyShortName) {
        this.currencyShortName = currencyShortName;
    }

}
