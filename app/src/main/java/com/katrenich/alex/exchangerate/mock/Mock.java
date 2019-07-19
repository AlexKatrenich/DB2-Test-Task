package com.katrenich.alex.exchangerate.mock;

import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.Currency;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.ExchangeDate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.PbExchangeRate;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class Mock {
    public static Single<List<PbExchangeRate>> getListPbExchangeRates(ExchangeDate date){
        Currency baseCurrency = new Currency("UAH");
        List<PbExchangeRate> list = new ArrayList<>();
        list.add(new PbExchangeRate(baseCurrency, new Currency("USD"), 26300, 25300));
        list.add(new PbExchangeRate(baseCurrency, new Currency("EUR"), 29300, 28300));
        list.add(new PbExchangeRate(baseCurrency, new Currency("RUB"), 400, 300));

        return Single.just(list);
    }
}
