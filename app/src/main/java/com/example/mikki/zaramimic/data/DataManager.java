package com.example.mikki.zaramimic.data;

import android.content.Context;

import com.example.mikki.zaramimic.data.database.DbHelper;
import com.example.mikki.zaramimic.data.database.IDbHelper;
import com.example.mikki.zaramimic.data.database.model.TodoNote;
import com.example.mikki.zaramimic.data.network.INetworkHelper;
import com.example.mikki.zaramimic.data.network.NetworkHelper;


public class DataManager implements  IDataManager{

    IDbHelper dbHelper;
    INetworkHelper networkHelper;
    public DataManager(Context context) {

        dbHelper = new DbHelper(context);
        networkHelper = new NetworkHelper();
    }


    @Override
    public void getCategoriesFromServer(OnCategoriesListener listener) {
        networkHelper.getCategoriesFromServer(listener);
    }

    @Override
    public void testDb(OnCategoriesListener listener) {
        networkHelper.testDb(listener);
    }

    @Override
    public void createRow(IDataManager.OnResponseListener listener) {
        dbHelper.createRow(listener);
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
