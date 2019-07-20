package com.katrenich.alex.exchangerate.exchange_rate_screen.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.katrenich.alex.exchangerate.R;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.BaseExchangeRate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.PbExchangeRate;

public class PbRecyclerViewItemHolder extends RecyclerView.ViewHolder{
    private TextView mCurrencyName, mCurrencyPurchasePrice, mCurrencySellingPrice;

    public PbRecyclerViewItemHolder(@NonNull View v) {
        super(v);
        mCurrencyName = v.findViewById(R.id.tv_pb_currency_list_item_short_name);
        mCurrencyPurchasePrice = v.findViewById(R.id.tv_pb_currency_list_item_purchase_price);
        mCurrencySellingPrice = v.findViewById(R.id.tv_pb_currency_list_item_selling_price);

    }

    public void bindView(PbExchangeRate pbExchangeRate){
        if(pbExchangeRate != null){
            mCurrencyName.setText(pbExchangeRate.getCurrentCurrency().getShortName());
            mCurrencySellingPrice.setText(BaseExchangeRate.getIntValuesToString(pbExchangeRate.getSaleValue()));
            mCurrencyPurchasePrice.setText(BaseExchangeRate.getIntValuesToString(pbExchangeRate.getBuyValue()));
        }
    }
}
