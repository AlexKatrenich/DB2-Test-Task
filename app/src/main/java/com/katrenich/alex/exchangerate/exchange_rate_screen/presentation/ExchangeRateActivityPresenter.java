package com.katrenich.alex.exchangerate.exchange_rate_screen.presentation;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katrenich.alex.exchangerate.App;
import com.katrenich.alex.exchangerate.R;
import com.katrenich.alex.exchangerate.exchange_rate_screen.ui.NbuExchangeRateFragment;
import com.katrenich.alex.exchangerate.exchange_rate_screen.ui.PbExchangeRateFragment;
import com.katrenich.alex.exchangerate.exchange_rate_screen.view.ExchangeRateMainView;
import com.katrenich.alex.exchangerate.exchange_rate_screen.util.ConnectionDetector;

@InjectViewState
public class ExchangeRateActivityPresenter extends MvpPresenter<ExchangeRateMainView> {

    public ExchangeRateActivityPresenter() {
        bindView();
        checkInternetConnection();
    }

    // check internet connection, if that false - showing message to user
    private void checkInternetConnection() {
        if (!ConnectionDetector.hasInternetConnection(App.getInstance())) getViewState().showMessage("Відсутній інтернет доступ");
    }

    // method for binding fragments to activity
    private void bindView() {
        getViewState().bindFragment(new NbuExchangeRateFragment(), R.id.nbu_exchange_rate_fragment_container);
        getViewState().bindFragment(new PbExchangeRateFragment(), R.id.pb_exchange_rate_fragment_container);
    }
}
