package com.example.mikki.zaramimic.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.database.model.ShoppingCartTableContract.ShoppingCartEntry;
import com.example.mikki.zaramimic.data.database.model.WishListTableContractor.WishListEntry;
import com.example.mikki.zaramimic.data.network.model.Product;

import java.util.ArrayList;
import java.util.List;


public class DbHelper implements IDbHelper{
    private static final String TAG = "DbHelper";
    SQLiteDatabase database;
    DatabaseOpenHelper openHelper;


    public DbHelper(Context context){
        openHelper = new DatabaseOpenHelper(context);
        database = openHelper.getWritableDatabase();
    }

    @Override
    public void addProductToShoppingCartDB(IDataManager.OnProductListener listener, Product product) {

        ContentValues values = new ContentValues();
        values.put(ShoppingCartEntry.Pid, product.getId());
        values.put(ShoppingCartEntry.Pname, product.getPname());
        values.put(ShoppingCartEntry.Pquantity,product.getQuantity());
        values.put(ShoppingCartEntry.Pprice, product.getPrize());
        values.put(ShoppingCartEntry.Pdiscription, product.getDiscription());
        values.put(ShoppingCartEntry.Pimage, product.getImage());


        database.insert(ShoppingCartEntry.TABLE_NAME,null,values);
        Log.d(TAG, "addProductToShoppingCartDB: " + values.toString());

        listener.isAddedToDB(true);
    }

    @Override
    public void readProductListFromShoppingCartDB(IDataManager.OnShoppingCartListener listener) {
        List<Product> productList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + ShoppingCartEntry.TABLE_NAME, null);
        Log.d(TAG, "readProductListFromShoppingCartDB: ");
        if(cursor.moveToFirst()) {
            do {
                Log.d(TAG, "readProductListFromShoppingCartDB: ");
                String pid = cursor.getString(cursor.getColumnIndex(ShoppingCartEntry.Pid));
                String pname = cursor.getString(cursor.getColumnIndex(ShoppingCartEntry.Pname));
                String pdiscription = cursor.getString(cursor.getColumnIndex(ShoppingCartEntry.Pdiscription));
                String pprice = cursor.getString(cursor.getColumnIndex(ShoppingCartEntry.Pprice));
                String pquantity = cursor.getString(cursor.getColumnIndex(ShoppingCartEntry.Pquantity));
                String pimage = cursor.getString(cursor.getColumnIndex(ShoppingCartEntry.Pimage));

                Product p = new Product(pid, pname, pquantity, pprice, pdiscription, pimage);
                productList.add(p);

            } while (cursor.moveToNext());

            listener.bindProductListFromDBToView(productList);
        }

    }

    @Override
    public void deleteProductFromShoppingCartDB(IDataManager.OnShoppingCartListener listener) {

    }

    @Override
    public void addProductToWishListDB(IDataManager.OnProductListener listener, Product product) {
        ContentValues values = new ContentValues();
        values.put(WishListEntry.Pid, product.getId());
        values.put(WishListEntry.Pname, product.getPname());
        values.put(WishListEntry.Pquantity,product.getQuantity());
        values.put(WishListEntry.Pprice, product.getPrize());
        values.put(WishListEntry.Pdiscription, product.getDiscription());
        values.put(WishListEntry.Pimage, product.getImage());


        database.insert(WishListEntry.TABLE_NAME,null,values);
        Log.d(TAG, "addProductToWishListDB: " + values.toString());

        listener.isAddedToDB(true);
    }

    @Override
    public void readProductsFromWishListDB(IDataManager.OnWishListListener listener) {
        List<Product> productList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + WishListEntry.TABLE_NAME, null);
        Log.d(TAG, "readWishListFromShoppingCartDB: ");
        if(cursor.moveToFirst()) {
            do {
                Log.d(TAG, "readWishListFromShoppingCartDB: ");
                String pid = cursor.getString(cursor.getColumnIndex(WishListEntry.Pid));
                String pname = cursor.getString(cursor.getColumnIndex(WishListEntry.Pname));
                String pdiscription = cursor.getString(cursor.getColumnIndex(WishListEntry.Pdiscription));
                String pprice = cursor.getString(cursor.getColumnIndex(WishListEntry.Pprice));
                String pquantity = cursor.getString(cursor.getColumnIndex(WishListEntry.Pquantity));
                String pimage = cursor.getString(cursor.getColumnIndex(WishListEntry.Pimage));

                Product p = new Product(pid, pname, pquantity, pprice, pdiscription, pimage);
                productList.add(p);

            } while (cursor.moveToNext());

            listener.bindProductsFromDBtoView(productList);
        }
    }


}
