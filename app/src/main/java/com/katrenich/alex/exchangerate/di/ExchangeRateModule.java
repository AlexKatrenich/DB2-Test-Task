package com.katrenich.alex.exchangerate.di;

import android.support.annotation.NonNull;

import com.katrenich.alex.exchangerate.exchange_rate_screen.presentation.SelectedCurrencyItem;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ExchangeRateModule {

    @Provides
    @NonNull
    @Singleton
    public SelectedCurrencyItem provideSelectedCurrencyItem(){
        return new SelectedCurrencyItem();
    }
}
