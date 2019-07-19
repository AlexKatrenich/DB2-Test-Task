package com.katrenich.alex.exchangerate.exchange_rate_screen.util;

import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.Currency;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.PbExchangeRate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.pojo.ExchangeRatePOJO;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.pojo.PBExchangeRatesPOJO;
import com.katrenich.alex.exchangerate.net.NetworkService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PbExchangeRateLoader {

    public static Single<List<PbExchangeRate>> getPrivatBankExchangeRate(String date){

       return NetworkService.getInstance()
                .getPbApiService()
                .getPbExchangeRateByDate(" ", date)
                .subscribeOn(Schedulers.io())
                .map(PBExchangeRatesPOJO::getExchangeRatePOJO)
                .map(PbExchangeRateLoader::deserializeFromPojo)
                .map(PbExchangeRateLoader::filterCurrency)
                .observeOn(AndroidSchedulers.mainThread());
    }


    private static List<PbExchangeRate> deserializeFromPojo(List<ExchangeRatePOJO> pojos){
        List<PbExchangeRate> list = new ArrayList<>();
        for (ExchangeRatePOJO pojo: pojos) {
            String baseCurrency = pojo.getBaseCurrency();
            String currentCurrency = pojo.getCurrency();
            Double saleValue = pojo.getSaleRate();
            Double buyValue = pojo.getPurchaseRate();
            if (baseCurrency != null
                    && currentCurrency != null
                    && saleValue != null
                    && buyValue != null){

                list.add(new PbExchangeRate(
                        new Currency(baseCurrency),
                        new Currency(currentCurrency),
                        (int) Math.round(saleValue*1000),
                        (int) Math.round(buyValue*1000)
                ));
            }
        }

        return list;
    }

    private static List<PbExchangeRate> filterCurrency(List<PbExchangeRate> list){
        if (list != null){
            List<PbExchangeRate> filterList = new ArrayList<>();

            for (PbExchangeRate rate : list) {
                Currency currency = rate.getCurrentCurrency();
                if(currency.getShortName().equals("EUR")
                        || currency.getShortName().equals("RUB")
                        || currency.getShortName().equals("USD")) {
                    filterList.add(rate);
                }
            }

            return filterList;
        }

        return list;
    }
}
