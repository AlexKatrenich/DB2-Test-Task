package com.katrenich.alex.exchangerate.exchange_rate_screen.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.katrenich.alex.exchangerate.R;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.PbExchangeRate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.ui.PbRecyclerViewItemHolder;

import java.util.ArrayList;
import java.util.List;

public class PbListAdapter extends RecyclerView.Adapter<PbRecyclerViewItemHolder> {
    private List<PbExchangeRate> mCurrencies;

    public PbListAdapter() {
        mCurrencies = new ArrayList<>();
    }

    public void setCurrencies(List<PbExchangeRate> currencies) {
        mCurrencies = currencies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PbRecyclerViewItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new PbRecyclerViewItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_nbu_currency_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PbRecyclerViewItemHolder mViewHolder, int position) {
        mViewHolder.bindView(mCurrencies.get(position));
        mViewHolder.itemView.setOnClickListener(v -> Toast.makeText(v.getContext(), "ClickOnPosition " + position, Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return mCurrencies.size();
    }

}
