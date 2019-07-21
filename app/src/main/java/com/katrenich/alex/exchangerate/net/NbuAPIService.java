package com.katrenich.alex.exchangerate.net;

import com.katrenich.alex.exchangerate.exchange_rate_screen.model.pojo.NBUExchangeRatePOJO;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NbuAPIService {

    @GET("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange")
    Single<List<NBUExchangeRatePOJO>> getNbuExchangeRateByDate(@Query("date") String date, @Query("json") String json);

}
