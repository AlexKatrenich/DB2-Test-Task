package com.katrenich.alex.exchangerate.exchange_rate_screen.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.katrenich.alex.exchangerate.R;
import com.katrenich.alex.exchangerate.exchange_rate_screen.adapter.PbListAdapter;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.ExchangeDate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.presentation.NbuExchangeRatePresenter;
import com.katrenich.alex.exchangerate.exchange_rate_screen.view.ExchangeRateNbuView;

import java.util.Calendar;

public class NbuExchangeRateFragment extends MvpAppCompatFragment implements ExchangeRateNbuView {
    public static final String TAG = "NbuExchangeRateFragment";

    @InjectPresenter
    NbuExchangeRatePresenter mPresenter;

    private RecyclerView mRecyclerView;
//    private NbuListAdapter mAdapter;
    private AppCompatImageButton btnDate;
    private TextView tvExchangeDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nbu_exchange_rate, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view, savedInstanceState);
    }

    private void initUI(View view, Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.rv_nbu_exchange_rate_fragment);
        btnDate = view.findViewById(R.id.ib_nbu_exchange_rate_fragment_date_picker);
        btnDate.setOnClickListener(mPresenter::onDatePickerClicked);
        tvExchangeDate = view.findViewById(R.id.tv_nbu_exchange_rate_date);
    }

    @Override
    public void updateUI() {
//        mPresenter.mData.observe(this, mAdapter::setCurrencies);
        mPresenter.exchangeRateDate.observe(this, exchangeDate -> tvExchangeDate.setText(exchangeDate.getStringValue()));
    }

    @Override
    public void showDatePickerDialog() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        try {
            DatePickerDialog dialog = new DatePickerDialog(
                    this.getContext(),
                    android.R.style.Theme_Material_Dialog_MinWidth,
                    (view, year1, month1, dayOfMonth) -> {
                        mPresenter.exchangeRateDate
                                .setValue(new ExchangeDate(year1, month1 + 1, dayOfMonth));
                        mPresenter.changedDate();

                    },
                    year, month, day);
            dialog.getDatePicker().setMaxDate(Calendar.getInstance().getTime().getTime());
            dialog.show();
        } catch (NullPointerException e){

        }
    }
}
