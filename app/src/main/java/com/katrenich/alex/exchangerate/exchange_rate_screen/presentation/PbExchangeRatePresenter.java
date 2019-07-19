package com.katrenich.alex.exchangerate.exchange_rate_screen.presentation;


import android.arch.lifecycle.MutableLiveData;
import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.ExchangeDate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.PbExchangeRate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.util.PbExchangeRateLoader;
import com.katrenich.alex.exchangerate.exchange_rate_screen.view.ExchangeRatePbView;

import java.util.List;


@InjectViewState
public class PbExchangeRatePresenter extends MvpPresenter<ExchangeRatePbView> {
    private boolean dataWasLoaded;
    public MutableLiveData<List<PbExchangeRate>> mData;
    public MutableLiveData<ExchangeDate> exchangeRateDate;

    public PbExchangeRatePresenter() {
        init();
        updateUI();
    }

    private void init() {
        mData = new MutableLiveData<>();
        dataWasLoaded = false;
        exchangeRateDate = new MutableLiveData<>();
        exchangeRateDate.setValue(ExchangeDate.getCurrentDate());
    }

    private void updateUI() {
        getViewState().updateUI();
        if (!dataWasLoaded) loadData();
    }

    public void changedDate(){
        loadData();
    }

    private void loadData() {
        PbExchangeRateLoader
                .getPrivatBankExchangeRate(exchangeRateDate.getValue().getStringValue())
                .subscribe(mData::setValue);


//        Mock.getListPbExchangeRates(exchangeRateDate.getValue()).subscribe(pbExchangeRates -> {
//            mData.setValue(pbExchangeRates);
//            dataWasLoaded = true;
//        });
    }


    public void onDatePickerClicked(View view) {
        getViewState().showDatePickerDialog();
    }

}
