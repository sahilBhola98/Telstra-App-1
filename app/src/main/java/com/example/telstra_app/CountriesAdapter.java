package com.example.telstra_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountryViewHolder> {
String[] mCountries;
private LayoutInflater mInFlater;
    public CountriesAdapter(String[] countries, Context context) {
        mCountries = countries;
        mInFlater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInFlater.inflate(R.layout.recyclelist_row,parent,false);
        return new CountryViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.CountryText.setText(mCountries[position]);
    }

    @Override
    public int getItemCount() {
        return mCountries.length;
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {
        public TextView CountryText;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            CountryText=itemView.findViewById(R.id.textViewCountry);
        }
    }
}
