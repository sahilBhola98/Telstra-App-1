package com.example.telstra_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerActivity extends AppCompatActivity {
    String[] countries = new String[]{"india","usa","europe"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView recycleViewCountry = findViewById(R.id.recycleViewCountries);
        CountriesAdapter adapter = new CountriesAdapter(countries,this);
        recycleViewCountry.setAdapter(adapter);
        recycleViewCountry.setLayoutManager(new LinearLayoutManager(this));
    }
}