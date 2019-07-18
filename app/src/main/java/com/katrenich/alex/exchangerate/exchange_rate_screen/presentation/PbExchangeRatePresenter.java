package com.katrenich.alex.exchangerate.exchange_rate_screen.presentation;


import android.arch.lifecycle.MutableLiveData;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.PbExchangeRate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.view.ExchangeRatePbView;
import com.katrenich.alex.exchangerate.mock.Mock;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@InjectViewState
public class PbExchangeRatePresenter extends MvpPresenter<ExchangeRatePbView> {
    private boolean dataWasLoaded;
    public MutableLiveData<List<PbExchangeRate>> mData;
    private Date exchangeRateDate;

    public PbExchangeRatePresenter() {
        init();
        updateUI();
    }

    private void init() {
        mData = new MutableLiveData<>();
        dataWasLoaded = false;
        exchangeRateDate = Calendar.getInstance().getTime();
    }

    private void updateUI() {
        getViewState().updateUI();
        if (!dataWasLoaded) loadData();
    }

    private void loadData() {
        Mock.getListPbExchangeRates(exchangeRateDate).subscribe(pbExchangeRates -> {
            mData.setValue(pbExchangeRates);
            dataWasLoaded = true;
        });
    }


}
