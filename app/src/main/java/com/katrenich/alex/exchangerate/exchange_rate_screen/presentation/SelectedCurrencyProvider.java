package com.katrenich.alex.exchangerate.exchange_rate_screen.presentation;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class SelectedCurrencyProvider {
    private String selectedCurrency = " ";
    private Subject<String> currency = BehaviorSubject.createDefault(selectedCurrency);

    public Subject<String> getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        selectedCurrency = currency;
        this.currency.onNext(selectedCurrency);
    }
}
