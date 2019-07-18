package com.katrenich.alex.exchangerate.net;

import com.katrenich.alex.exchangerate.exchange_rate_screen.model.pojo.PBExchangeRates;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PrivatBankAPIService {

    @GET("exchange_rates")
    Single<PBExchangeRates> getPbExchangeRateByDate(@Query("json") String mJson, @Query("date") String mDate);

}
