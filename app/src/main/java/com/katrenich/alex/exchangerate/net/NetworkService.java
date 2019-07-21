package com.katrenich.alex.exchangerate.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static final NetworkService mInstance = new NetworkService();
    private Retrofit mRetrofit;

    public static NetworkService getInstance() {
        return mInstance;
    }

    private NetworkService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder().addInterceptor(interceptor);

        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.privatbank.ua/p24api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client.build())
                .build();
    }

    public PrivatBankAPIService getPbApiService(){
        return mRetrofit.create(PrivatBankAPIService.class);
    }

    public NbuAPIService getNbuApiService(){
        return mRetrofit.create(NbuAPIService.class);
    }

}
