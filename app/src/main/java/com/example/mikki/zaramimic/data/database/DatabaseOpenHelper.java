package com.example.mikki.zaramimic.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mikki.zaramimic.data.database.model.ShoppingCartTableContract.ShoppingCartEntry;


public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ShoppingCartEntry.TABLE_NAME + " (" +
                    ShoppingCartEntry._ID + " INTEGER PRIMARY KEY," +
                    ShoppingCartEntry.Pid + TEXT_TYPE + COMMA_SEP +
                    ShoppingCartEntry.Pname + TEXT_TYPE + COMMA_SEP +
                    ShoppingCartEntry.Pquantity + TEXT_TYPE + COMMA_SEP +
                    ShoppingCartEntry.Pprice + TEXT_TYPE + COMMA_SEP +
                    ShoppingCartEntry.Pdiscription + TEXT_TYPE + COMMA_SEP +
                    ShoppingCartEntry.Pimage+TEXT_TYPE+  " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ShoppingCartEntry.TABLE_NAME;




    public DatabaseOpenHelper(Context context) {
        super(context,"zaraDatabase",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
