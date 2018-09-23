package com.example.mikki.zaramimic.data;

import android.content.Context;

import com.example.mikki.zaramimic.data.database.DbHelper;
import com.example.mikki.zaramimic.data.database.IDbHelper;
import com.example.mikki.zaramimic.data.database.model.TodoNote;
import com.example.mikki.zaramimic.data.network.INetworkHelper;
import com.example.mikki.zaramimic.data.network.NetworkHelper;
import com.example.mikki.zaramimic.data.network.model.Login;
import com.example.mikki.zaramimic.data.network.model.UserProfile;


public class DataManager implements  IDataManager{

    IDbHelper dbHelper;
    INetworkHelper networkHelper;
    public DataManager(Context context) {

        dbHelper = new DbHelper(context);
        networkHelper = new NetworkHelper(context);
    }


    @Override
    public void checkLoginValidation(OnLoginListener listener, Login login) {
        networkHelper.checkLoginValidation(listener, login);
    }

    @Override
    public void checkEmailFromServer(OnForgotPWListener listener, String email) {
        networkHelper.checkEmailFromServer(listener, email);
    }

    @Override
    public void userRegistration(OnSignUpListener listener, UserProfile profile) {
        networkHelper.userRegistration(listener, profile);
    }


    @Override
    public void getCategoriesFromServer(OnCategoriesListener listener) {
        networkHelper.getCategoriesFromServer(listener);
    }

    @Override
    public void getSubCategoriesFromServer(OnSubCategoriesListener listener) {
        networkHelper.getSubCategoriesFromServer(listener);
    }

    @Override
    public void getProductListFromServer(OnProductListListener listener) {
        networkHelper.getProductListFromServer(listener);
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
