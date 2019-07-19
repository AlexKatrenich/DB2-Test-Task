package com.katrenich.alex.exchangerate.exchange_rate_screen.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.katrenich.alex.exchangerate.App;
import com.katrenich.alex.exchangerate.R;
import com.katrenich.alex.exchangerate.exchange_rate_screen.model.entities.PbExchangeRate;
import com.katrenich.alex.exchangerate.exchange_rate_screen.ui.PbRecyclerViewItemHolder;

import java.util.ArrayList;
import java.util.List;

public class PbListAdapter extends RecyclerView.Adapter<PbRecyclerViewItemHolder> {
    private List<PbExchangeRate> mCurrencies;
    private OnItemClickListener mItemClickListener;
    private int selectedPosition = -1;

    public PbListAdapter(OnItemClickListener itemClickListener) {
        mCurrencies = new ArrayList<>();
        mItemClickListener = itemClickListener;
    }

    public void setCurrencies(List<PbExchangeRate> currencies) {
        mCurrencies = currencies;
        notifyDataSetChanged();
    }

    public void setSelectedPosition(int position){
        if(position < mCurrencies.size()){
            selectedPosition = position;
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public PbRecyclerViewItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new PbRecyclerViewItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_nbu_currency_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PbRecyclerViewItemHolder mViewHolder, int position) {
        if(selectedPosition == position){
            mViewHolder.itemView.setBackgroundColor(App.getInstance().getResources().getColor(R.color.PbExchangeRatesListItemBackgroundSelected));
        } else {
            mViewHolder.itemView.setBackgroundColor(App.getInstance().getResources().getColor(R.color.PbExchangeRatesListItemBackgroundNonSelected));
        }

        mViewHolder.bindView(mCurrencies.get(position));
        mViewHolder.itemView.setOnClickListener(v -> {
            mItemClickListener.onItemListClicked(v, position);
            selectedPosition = position;
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return mCurrencies.size();
    }

}
