package com.katrenich.alex.exchangerate.di;

import com.katrenich.alex.exchangerate.exchange_rate_screen.presentation.NbuExchangeRatePresenter;
import com.katrenich.alex.exchangerate.exchange_rate_screen.presentation.PbExchangeRatePresenter;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {ExchangeRateModule.class})
@Singleton
public interface AppComponent {

    void inject (PbExchangeRatePresenter pbPresenter);

    void inject (NbuExchangeRatePresenter nbuPresenter);

}
