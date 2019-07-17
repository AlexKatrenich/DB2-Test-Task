package com.katrenich.alex.exchangerate.exchange_rate_screen.view;

import android.support.v4.app.Fragment;

import com.arellomobile.mvp.MvpView;

public interface ExchangeRateMainView extends MvpView {
    void bindFragment(Fragment fragment, int container);
}
