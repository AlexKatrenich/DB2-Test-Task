package com.katrenich.alex.exchangerate.exchange_rate_screen.presentation;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katrenich.alex.exchangerate.R;
import com.katrenich.alex.exchangerate.exchange_rate_screen.ui.NbuExchangeRateFragment;
import com.katrenich.alex.exchangerate.exchange_rate_screen.ui.PbExchangeRateFragment;
import com.katrenich.alex.exchangerate.exchange_rate_screen.view.ExchangeRateMainView;

@InjectViewState
public class ExchangeRateActivityPresenter extends MvpPresenter<ExchangeRateMainView> {
    public static final String TAG = "ExchangeRateActivityP";

    public ExchangeRateActivityPresenter() {
        Log.i(TAG, "ExchangeRateActivityPresenter: ");
        bindView();
    }

    private void bindView() {
        Log.i(TAG, "bindView: ");
        getViewState().bindFragment(new NbuExchangeRateFragment(), R.id.nbu_exchange_rate_fragment_container);
        getViewState().bindFragment(new PbExchangeRateFragment(), R.id.pb_exchange_rate_fragment_container);
    }
}
