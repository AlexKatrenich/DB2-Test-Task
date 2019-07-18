package com.katrenich.alex.exchangerate.exchange_rate_screen.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.katrenich.alex.exchangerate.R;
import com.katrenich.alex.exchangerate.exchange_rate_screen.adapter.PbListAdapter;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.PbExchangeRate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.presentation.PbExchangeRatePresenter;
import com.katrenich.alex.exchangerate.exchange_rate_screen.view.ExchangeRatePbView;

import java.util.List;

public class PbExchangeRateFragment extends MvpAppCompatFragment implements ExchangeRatePbView {
    public static final String TAG = "PbExchangeRateFragment";

    @InjectPresenter
    PbExchangeRatePresenter mPresenter;

    private RecyclerView mRecyclerView;
    private PbListAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pb_exchange_rate, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(savedInstanceState, view);
    }

    private void initUI(Bundle savedInstanceState, View view) {
        mRecyclerView = view.findViewById(R.id.rv_pb_exchange_rate_fragment);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new PbListAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void updateUI() {
        mPresenter.mData.observe(this, mAdapter::setCurrencies);
    }
}
