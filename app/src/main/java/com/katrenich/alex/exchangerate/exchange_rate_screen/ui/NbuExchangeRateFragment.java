package com.katrenich.alex.exchangerate.exchange_rate_screen.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.katrenich.alex.exchangerate.R;
import com.katrenich.alex.exchangerate.exchange_rate_screen.presentation.NbuExchangeRatePresenter;
import com.katrenich.alex.exchangerate.exchange_rate_screen.view.ExchangeRateNbuView;

public class NbuExchangeRateFragment extends MvpAppCompatFragment implements ExchangeRateNbuView {
    public static final String TAG = "NbuExchangeRateFragment";

    @InjectPresenter
    NbuExchangeRatePresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nbu_exchange_rate, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
