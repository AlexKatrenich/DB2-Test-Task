package com.katrenich.alex.exchangerate.exchange_rate_screen.presentation;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class SelectedCurrencyItem {
    public static final String TAG = "SelectedCurrencyItem";
    private String selectedCurrency = " ";
    private Subject<String> currency = BehaviorSubject.createDefault(selectedCurrency);


    @Inject
    public SelectedCurrencyItem() {
        Log.i(TAG, "SelectedCurrencyItem: ");
    }

    public Subject<String> getCurrency() {
        return currency;
    }

    public void setCurrencyByName(String currency) {
        selectedCurrency = currency;
        Log.i(TAG, "setCurrencyByName: " + currency);
        this.currency.onNext(selectedCurrency);
    }

}
