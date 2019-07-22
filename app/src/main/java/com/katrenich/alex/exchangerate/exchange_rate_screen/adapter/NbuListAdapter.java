package com.katrenich.alex.exchangerate.exchange_rate_screen.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.katrenich.alex.exchangerate.App;
import com.katrenich.alex.exchangerate.R;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.NbuExchangeRate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.ui.NbuRecyclerViewItemHolder;

import java.util.ArrayList;
import java.util.List;

public class NbuListAdapter extends RecyclerView.Adapter<NbuRecyclerViewItemHolder> {
    private List<NbuExchangeRate> mCurrencies;

    public NbuListAdapter() {
        mCurrencies = new ArrayList<>();
    }

    public void setCurrencies(List<NbuExchangeRate> currencies) {
        mCurrencies = currencies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NbuRecyclerViewItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NbuRecyclerViewItemHolder(
                LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_nbu_currency_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NbuRecyclerViewItemHolder viewHolder, int position) {
        viewHolder.bindView(mCurrencies.get(position));
        if (position % 2 == 0) {
            viewHolder.itemView.setBackgroundColor(App.getInstance().getResources().getColor(android.R.color.darker_gray));
        } else {
            viewHolder.itemView.setBackgroundColor(App.getInstance().getResources().getColor(android.R.color.transparent));
        }
    }

    @Override
    public int getItemCount() {
        return mCurrencies.size();
    }


}
