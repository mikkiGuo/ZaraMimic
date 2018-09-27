package com.example.mikki.zaramimic.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mikki.zaramimic.data.database.model.ShoppingCartTableContract.ShoppingCartEntry;
import com.example.mikki.zaramimic.data.database.model.WishListTableContractor;


public class DatabaseOpenHelper extends SQLiteOpenHelper {

    SqlQueries sqlQueries = SqlQueries.getInstance();

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ShoppingCartEntry.TABLE_NAME;
    private static final String SQL_DELETE_ENTRIES2 =
            "DROP TABLE IF EXISTS " + WishListTableContractor.WishListEntry.TABLE_NAME;

    public DatabaseOpenHelper(Context context) {
        super(context,"zaraDatabase",null, 7);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String shoppingCartTable = sqlQueries.createShoppingCartTable();
        db.execSQL(shoppingCartTable);
        String wishListTable = sqlQueries.createWishListTable();
        db.execSQL(wishListTable);
        String userProfileTable = sqlQueries.createUserProfileTable();
        db.execSQL(userProfileTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_DELETE_ENTRIES2);
        onCreate(db);
    }
}
