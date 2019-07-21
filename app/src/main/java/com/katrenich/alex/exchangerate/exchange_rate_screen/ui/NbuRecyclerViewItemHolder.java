package com.katrenich.alex.exchangerate.exchange_rate_screen.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.katrenich.alex.exchangerate.R;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.BaseExchangeRate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.NbuExchangeRate;

public class NbuRecyclerViewItemHolder extends RecyclerView.ViewHolder{
    private TextView mCurrencyName, mCurrencyPrice, mBaseCurrencyValue;

    public NbuRecyclerViewItemHolder(@NonNull View v) {
        super(v);
        mCurrencyName = v.findViewById(R.id.tv_nbu_currency_list_item_full_name);
        mCurrencyPrice = v.findViewById(R.id.tv_nbu_currency_list_item_purchase_price);
        mBaseCurrencyValue = v.findViewById(R.id.tv_nbu_currency_list_item_base_currency);
    }

    public void bindView(NbuExchangeRate nbuExchangeRate){
        if(nbuExchangeRate != null){
            String name = nbuExchangeRate.getCurrentCurrency().getFullName();
            String rate = BaseExchangeRate.getIntValuesToString(nbuExchangeRate.getValue());
            String baseCurrencyValue = "1 " + nbuExchangeRate.getBaseCurrency().getShortName();
            if(name != null) mCurrencyName.setText(name);
            if(rate != null) mCurrencyPrice.setText(rate);
            if(baseCurrencyValue != null) mBaseCurrencyValue.setText(baseCurrencyValue);
        }
    }


}
