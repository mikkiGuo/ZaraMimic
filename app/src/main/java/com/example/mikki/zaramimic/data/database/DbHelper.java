package com.example.mikki.zaramimic.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.database.model.TodoContract.TodoEntry;
import com.example.mikki.zaramimic.data.database.model.TodoNote;


public class DbHelper implements IDbHelper{
    private static final String TAG = "DbHelper";
    SQLiteDatabase database;
    DatabaseOpenHelper openHelper;

    public DbHelper(Context context){
        openHelper = new DatabaseOpenHelper(context);
        database = openHelper.getWritableDatabase();
    }

    @Override
    public void createRow(IDataManager.OnResponseListener listener) {
            //listener.connectToDb();
    }

    @Override
    public void readRow() {

    }

    @Override
    public void updateRow() {

    }

    @Override
    public void deleteRow() {

    }
}
