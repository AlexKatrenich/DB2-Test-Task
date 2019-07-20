package com.katrenich.alex.exchangerate.exchange_rate_screen.presentation;

import android.arch.lifecycle.MutableLiveData;
import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.ExchangeDate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.PbExchangeRate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.view.ExchangeRateNbuView;

import java.util.List;

@InjectViewState
public class NbuExchangeRatePresenter extends MvpPresenter<ExchangeRateNbuView> {
    private boolean dataWasLoaded;
    public MutableLiveData<List<PbExchangeRate>> mData;
    public MutableLiveData<ExchangeDate> exchangeRateDate;

    public NbuExchangeRatePresenter() {
        init();
        updateUI();
    }


    private void init() {
        dataWasLoaded = false;
        mData = new MutableLiveData<>();
        exchangeRateDate = new MutableLiveData<>();
        exchangeRateDate.setValue(ExchangeDate.getCurrentDate());
    }

    private void updateUI() {
        getViewState().updateUI();
        if(!dataWasLoaded) loadData();
    }

    private void loadData() {

    }

    public void changedDate(){
        loadData();
    }

    public void onDatePickerClicked(View view) {
        getViewState().showDatePickerDialog();
    }

}
