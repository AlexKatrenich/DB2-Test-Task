package com.katrenich.alex.exchangerate.net;

import com.katrenich.alex.exchangerate.exchange_rate_screen.model.pojo.PBExchangeRatesPOJO;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PrivatBankAPIService {

    @GET("exchange_rates")
    Single<PBExchangeRatesPOJO> getPbExchangeRateByDate(@Query("json") String mJson, @Query("date") String mDate);

}
