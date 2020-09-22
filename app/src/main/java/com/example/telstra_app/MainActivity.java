package com.example.telstra_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName() ;
    EditText nameEditText;
    @Override
    protected void onStart() {

        super.onStart();
        Log.i(TAG,"It has started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"It has paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"It has paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"It has resumed");
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log.i(TAG,"mainactivity created");
        nameEditText = findViewById(R.id.personView);
    }
    static{
        int a=add(10,30);
    }

    protected static int add(int i, int i1) {
        return i+i1;
    }

    public void clickListener(View view) {
        Log.e(TAG,"button Clicked");
        switch(view.getId()){
            case R.id.buttonLogin:
                startHomeActivity();
                break;
            case R.id.buttonCancel:
                Log.v(TAG,"dialing phone num");
                Intent dIntent = new Intent();
                dIntent.setAction(Intent.ACTION_DIAL);
                dIntent.setData(Uri.parse("tel:9871973714"));
                startActivity(dIntent);
                break;
        }
    }
    public void startHomeActivity(){
        Log.w(TAG,"Home Activity started");
        String name = nameEditText.getText().toString();
        Toast.makeText(this, "Welcome "+name+" to android", Toast.LENGTH_SHORT).show();
        Intent hIntent = new Intent(MainActivity.this,HomeActivity.class);
        hIntent.putExtra("StudentValue","Arvind");
        startActivity(hIntent);
    }

}