package com.example.telstra_app.database;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.example.telstra_app.database.FeedReaderContract.FeedEntry;
import com.example.telstra_app.R;
public class dbActivity extends AppCompatActivity {
    private static final String TAG = dbActivity.class.getSimpleName() ;
    EditText titleET, subtitleET;
    ListView dblistView;
    DAO dao;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        titleET = findViewById(R.id.titleEdittext);
        subtitleET = findViewById(R.id.subtitleedittext);
        dao = new DAO(this);
        dao.openDb();

        dblistView = findViewById(R.id.dblist);
        Cursor dataCursor = dao.readRows();

        CursorAdapter adapter = new SimpleCursorAdapter(dbActivity.this,
                android.R.layout.simple_list_item_2,
                dataCursor,
                new String[]{FeedEntry.COLUMN_NAME_TITLE,FeedEntry.COLUMN_NAME_SUBTITLE},
                new int[]{android.R.id.text1,android.R.id.text2});
        dblistView.setAdapter(adapter);
    }
    public void handleDbClicks(View view){
        switch(view.getId()){
            case R.id.buttonput:
                putDb();
                break;
            case R.id.buttonget:
                getDb();
                break;
        }
    }

    private void getDb() {
        String result=dao.readRow();
        TextView resultTextView = findViewById(R.id.textViewdb);
        resultTextView.setText(result);
    }

    private void putDb() {
        Log.i(TAG,"you are putting to database");
        String title=titleET.getText().toString();
        String subtitle = subtitleET.getText().toString();
        dao.createRow(title,subtitle);
    }
}
