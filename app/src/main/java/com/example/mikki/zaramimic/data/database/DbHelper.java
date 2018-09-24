package com.example.mikki.zaramimic.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.database.model.ShoppingCartTableContract.ShoppingCartEntry;
import com.example.mikki.zaramimic.data.network.model.Product;


public class DbHelper implements IDbHelper{
    private static final String TAG = "DbHelper";
    SQLiteDatabase database;
    DatabaseOpenHelper openHelper;

    public DbHelper(Context context){
        openHelper = new DatabaseOpenHelper(context);
        database = openHelper.getWritableDatabase();
    }

    @Override
    public void addProductToDB(IDataManager.OnProductListener listener, Product product) {
        ContentValues values = new ContentValues();
        values.put(ShoppingCartEntry.Pid, product.getId());
        values.put(ShoppingCartEntry.Pname, product.getPname());
        values.put(ShoppingCartEntry.Pquantity,product.getQuantity());
        values.put(ShoppingCartEntry.Pprice, product.getPrize());
        values.put(ShoppingCartEntry.Pdiscription, product.getDiscription());
        values.put(ShoppingCartEntry.Pimage, product.getImage());

        database.insert(ShoppingCartEntry.TABLE_NAME,null,values);
        Log.d(TAG, "addProductToDB: " + values.toString());

        listener.isAddedToDB(true);
    }



}
