package com.katrenich.alex.exchangerate.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static final NetworkService mInstance = new NetworkService();
    private Retrofit mRetrofit;

    public static NetworkService getInstance() {
        return mInstance;
    }

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.privatbank.ua/p24api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public PrivatBankAPIService getPbApiService(){
        return mRetrofit.create(PrivatBankAPIService.class);
    }
}
