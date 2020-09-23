package com.example.telstra_app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.telstra_app.database.FeedReaderContract.FeedEntry;
import android.database.Cursor;
import android.provider.ContactsContract;

/**
 * Database access Object
 * access db here crud requests
 */
public class DAO {
    SQLiteDatabase database;
    FeedReaderdbHelper helper;

    public DAO(Context context){
        helper = new FeedReaderdbHelper(context);
    }
    public void openDb(){
        database = helper.getWritableDatabase();
    }
    public void closeDb(){
        database.close();
    }
    public void createRow(String title , String subtitle){
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE,title);
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE,subtitle);
        database.insert(FeedEntry.TABLE_NAME,null,values);
    }
    /**
     * now creating a pointer/cursor to db
     */

    public Cursor readRows(){
        return database.query(FeedEntry.TABLE_NAME,null,null,null,null,null,null);
    }
    public String readRow(){
        Cursor cursor = database.query(FeedEntry.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToLast();
        int titleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE);
        int subtitleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE);
        String title = cursor.getString(titleIndex);
        String subTitle = cursor.getString(subtitleIndex);

        return title + "\n"+ subTitle;
    }

    public void updateRow() {

    }

    public void deleteRow(){};
    public void createRow(Note note){
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE,note.getTitle());
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE,note.getSubTitle());
        database.insert(FeedEntry.TABLE_NAME,null,values);
    }
}
