package com.katrenich.alex.exchangerate.exchange_rate_screen.presentation;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;
import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katrenich.alex.exchangerate.App;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.Currency;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.ExchangeDate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.NbuExchangeRate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.util.NbuExchangeRateLoader;
import com.katrenich.alex.exchangerate.exchange_rate_screen.view.ExchangeRateNbuView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

@InjectViewState
public class NbuExchangeRatePresenter extends MvpPresenter<ExchangeRateNbuView> {
    private static final String TAG = "NbuExchangeRateP";
    private boolean dataWasLoaded;
    public MutableLiveData<List<NbuExchangeRate>> mData;
    public MutableLiveData<ExchangeDate> exchangeRateDate;

    @Inject
    SelectedCurrencyItem mSelectedCurrencyItem;
    private Disposable mDisposable;

    public NbuExchangeRatePresenter() {
        init();
        updateUI();
    }

    private void init() {
        dataWasLoaded = false;
        mData = new MutableLiveData<>();
        exchangeRateDate = new MutableLiveData<>();
        exchangeRateDate.setValue(ExchangeDate.getCurrentDate());
        App.getComponent().inject(this);
        mDisposable = mSelectedCurrencyItem.getCurrency().subscribe(this::changeSelectedCurrency);
    }

    private void updateUI() {
        getViewState().updateUI();
        if(!dataWasLoaded) loadData();
    }

    private void loadData() {
        NbuExchangeRateLoader
                .getNbuExchangeRate(exchangeRateDate.getValue().getStringValueForNbuAPI())
                .subscribe(mData::setValue, throwable -> Log.e(TAG, "loadData: ", throwable));
    }

    public void changedDate(){
        loadData();
    }

    public void onDatePickerClicked(View view) {
        getViewState().showDatePickerDialog();
    }

    private void changeSelectedCurrency(String currentCurrencyShortName){
        List<NbuExchangeRate> rates = mData.getValue();
        if (rates == null) return;

        for (int i = 0; i < rates.size(); i++) {
            Currency currency = rates.get(i).getCurrentCurrency();
            if(currency.getShortName().equals(currentCurrencyShortName)){
                getViewState().showSelectedCurrencyInAdapterPosition(i);
            }
        }
    }

    @Override
    public void onDestroy() {
        if (mDisposable != null) mDisposable.dispose();
        super.onDestroy();
    }
}
