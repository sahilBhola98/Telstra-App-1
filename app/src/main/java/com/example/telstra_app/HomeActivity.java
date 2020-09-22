package com.example.telstra_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private static final String TAG = HomeActivity.class.getSimpleName() ;
    String[] countries = new String[]{"india","usa","europe"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ListView countriesList = findViewById(R.id.countriesView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                countries);
        countriesList.setAdapter(adapter);
        countriesList.setOnItemClickListener(this);

        Log.i(TAG,"Welcome");
        if(getIntent().getExtras()!=null) {
            String eName = getIntent().getExtras().getString("StudentName");
            TextView nameTextView = findViewById(R.id.textViewname);
            nameTextView.setText(eName);
        }



    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String item= (String) adapterView.getItemAtPosition(position);
        Toast.makeText(this,item , Toast.LENGTH_SHORT).show();
    }
}