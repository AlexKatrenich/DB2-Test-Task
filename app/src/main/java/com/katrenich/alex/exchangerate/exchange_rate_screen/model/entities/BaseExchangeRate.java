package com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities;

public class BaseExchangeRate {
    private Currency baseCurrency;
    private Currency currentCurrency;

    public BaseExchangeRate(Currency baseCurrency, Currency currentCurrency) {
        this.baseCurrency = baseCurrency;
        this.currentCurrency = currentCurrency;
    }

    public Currency getBaseCurrency() {
        return baseCurrency;
    }

    public Currency getCurrentCurrency() {
        return currentCurrency;
    }

    public void setBaseCurrency(Currency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public void setCurrentCurrency(Currency currentCurrency) {
        this.currentCurrency = currentCurrency;
    }

    @Override
    public String toString() {
        return "BaseExchangeRate{" +
                "baseCurrency=" + baseCurrency +
                ", currentCurrency=" + currentCurrency +
                '}';
    }

    public static String getIntValuesToString(int i){
        StringBuffer stringValue = new StringBuffer(String.valueOf(i));
        switch (stringValue.length()){
            case 0 : {
                stringValue.append("0.000");
                break;
            }
            case 1: {
                stringValue.insert(0, "0.00");
                break;
            }
            case 2: {
                stringValue.insert(0, "0.0");
                break;
            }
            case 3 : {
                stringValue.insert(0, "0");
            }
            default: {
                stringValue.insert(stringValue.length() - 3, '.');
            }
        }

        return stringValue.toString();
    }
}
