package com.example.telstra_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Toggler extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggler);
    }



    public void clickListen(View view) {
        Button btn = findViewById(view.getId());
        btn.setBackgroundColor(Color.RED);
    }



}