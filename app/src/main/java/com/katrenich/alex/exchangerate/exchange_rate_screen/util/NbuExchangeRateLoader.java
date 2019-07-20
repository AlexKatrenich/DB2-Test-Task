package com.katrenich.alex.exchangerate.exchange_rate_screen.util;

import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.Currency;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.NbuExchangeRate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.pojo.ExchangeRatePOJO;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.pojo.PBExchangeRatesPOJO;
import com.katrenich.alex.exchangerate.net.NetworkService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NbuExchangeRateLoader {
    public static Single<List<NbuExchangeRate>> getNbuExchangeRate(String date){
        if (date == null) return null;

        return NetworkService.getInstance()
                .getPbApiService().getPbExchangeRateByDate(" ", date)
                .subscribeOn(Schedulers.io())
                .map(PBExchangeRatesPOJO::getExchangeRatePOJO)
                .map(NbuExchangeRateLoader::deserializeFromPojo)
                .observeOn(AndroidSchedulers.mainThread());
    }

    private static List<NbuExchangeRate> deserializeFromPojo(List<ExchangeRatePOJO> pojos){
        List<NbuExchangeRate> list = new ArrayList<>();

        for (ExchangeRatePOJO pojo : pojos ) {
            String currentCurrency = pojo.getCurrency();
            Double saleRateNB = pojo.getSaleRateNB();
            String baseCurrency = pojo.getBaseCurrency();
            if (baseCurrency != null
                    && currentCurrency != null
                    && saleRateNB != null){
                list.add(new NbuExchangeRate(
                        new Currency(baseCurrency),
                        new Currency(currentCurrency),
                        (int) Math.round(saleRateNB*1000)
                ));
            }
        }

        return list;
    }

}
