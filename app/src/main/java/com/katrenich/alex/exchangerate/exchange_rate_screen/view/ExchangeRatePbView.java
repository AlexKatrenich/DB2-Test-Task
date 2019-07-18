package com.katrenich.alex.exchangerate.exchange_rate_screen.view;

import com.arellomobile.mvp.MvpView;

import java.util.Date;


public interface ExchangeRatePbView extends MvpView {
    void updateUI();
    Date showDatePickerDialog();
}
