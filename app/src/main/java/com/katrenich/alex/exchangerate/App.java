package com.katrenich.alex.exchangerate;

import android.app.Application;

import com.katrenich.alex.exchangerate.di.AppComponent;
import com.katrenich.alex.exchangerate.di.DaggerAppComponent;
import com.katrenich.alex.exchangerate.di.ExchangeRateModule;

public class App extends Application {
    private static App instance;
    private static AppComponent sComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        sComponent = buildComponent();
    }

    public static AppComponent getComponent(){
        return sComponent;
    }

    protected AppComponent buildComponent(){
        return DaggerAppComponent.builder()
                .exchangeRateModule(new ExchangeRateModule())
                .build();
    }

    public static App getInstance(){
        return instance;
    }
}
