package com.katrenich.alex.exchangerate.exchange_rate_screen.util;

import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.Currency;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.NbuExchangeRate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.pojo.NBUExchangeRatePOJO;
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
                .getNbuApiService()
                .getNbuExchangeRateByDate(date, " ")
                .subscribeOn(Schedulers.io())
                .map(NbuExchangeRateLoader::deserializeFromPojo)
                .observeOn(AndroidSchedulers.mainThread());
    }

    private static List<NbuExchangeRate> deserializeFromPojo(List<NBUExchangeRatePOJO> pojos){
        List<NbuExchangeRate> list = new ArrayList<>();

        for (NBUExchangeRatePOJO pojo : pojos ) {
            String fullName = pojo.getCurrencyFullName();
            String shortName = pojo.getCurrencyShortName();
            Double saleRateNB = pojo.getRate();
            if (fullName != null
                    && shortName != null
                    && saleRateNB != null){

                list.add(new NbuExchangeRate(
                        new Currency("UAH"),
                        new Currency(shortName, fullName),
                        (int) Math.round(saleRateNB*1000)
                ));
            }
        }

        return list;
    }

}
