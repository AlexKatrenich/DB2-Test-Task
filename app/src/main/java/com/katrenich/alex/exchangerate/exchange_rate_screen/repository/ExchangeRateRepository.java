package com.katrenich.alex.exchangerate.exchange_rate_screen.repository;

import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.BaseExchangeRate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.Currency;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.PbExchangeRate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.pojo.ExchangeRatePOJO;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.pojo.PBExchangeRates;
import com.katrenich.alex.exchangerate.net.NetworkService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ExchangeRateRepository implements Repository<List<BaseExchangeRate>, String> {
    private List<BaseExchangeRate> mList;

    public ExchangeRateRepository() {
        mList = new ArrayList<>();
    }

    @Override
    public void loadData(String... strings) {
        if(strings.length == 1) {
            String date = strings[0];
            NetworkService.getInstance()
                    .getPbApiService()
                    .getPbExchangeRateByDate(" ", date)
                    .subscribeOn(Schedulers.io())
                    .map(PBExchangeRates::getExchangeRatePOJO)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(exchangeRatePOJOS -> ExchangeRateRepository.getEntityFromPOJO(exchangeRatePOJOS, mList));
        }
    }

    @Override
    public List<BaseExchangeRate> getData() {
        return mList;
    }

    private static void getEntityFromPOJO(List<ExchangeRatePOJO> pojos, List<BaseExchangeRate> list){
        for (ExchangeRatePOJO pojo: pojos) {
            String baseCurrency = pojo.getBaseCurrency();
            String currentCurrency = pojo.getCurrency();

            if (baseCurrency != null && currentCurrency != null){
                list.add(new PbExchangeRate(
                                new Currency(baseCurrency),
                                new Currency(currentCurrency)
                ));
            }
        }
    }
}
