package com.katrenich.alex.exchangerate.exchange_rate_screen.adapter;

import android.support.v7.widget.RecyclerView;

import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.NbuExchangeRate;

import java.util.List;

public class NbuListAdapter extends RecyclerView.Adapter<> {
    private List<NbuExchangeRate> mCurrencies;
    private OnItemClickListener mItemClickListener;


}
