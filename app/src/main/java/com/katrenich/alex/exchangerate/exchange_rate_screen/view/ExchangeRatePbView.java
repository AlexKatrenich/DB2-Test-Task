package com.katrenich.alex.exchangerate.exchange_rate_screen.view;

import android.view.View;

import com.arellomobile.mvp.MvpView;


public interface ExchangeRatePbView extends MvpView {
    void updateUI();
    void showDatePickerDialog();
}
