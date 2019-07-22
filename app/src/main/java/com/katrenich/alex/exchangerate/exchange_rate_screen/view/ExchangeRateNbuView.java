package com.katrenich.alex.exchangerate.exchange_rate_screen.view;

import com.arellomobile.mvp.MvpView;

public interface ExchangeRateNbuView extends MvpView {
    void updateUI();
    void showDatePickerDialog();
    void showSelectedCurrencyInAdapterPosition(int position);
}
