package com.katrenich.alex.exchangerate.exchange_rate_screen.view;

import com.arellomobile.mvp.MvpView;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.ExchangeDate;


public interface ExchangeRatePbView extends MvpView {
    void updateUI();
    void showDatePickerDialog();
}
