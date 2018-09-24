package com.example.mikki.zaramimic.data;

import android.content.Context;

import com.example.mikki.zaramimic.data.database.DbHelper;
import com.example.mikki.zaramimic.data.database.IDbHelper;
import com.example.mikki.zaramimic.data.network.INetworkHelper;
import com.example.mikki.zaramimic.data.network.NetworkHelper;
import com.example.mikki.zaramimic.data.network.model.Login;
import com.example.mikki.zaramimic.data.network.model.Product;
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
    public void sendEmailToServerForReset(OnForgotPWListener listener, String email) {
        networkHelper.sendEmailToServerForReset(listener, email);
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


    /*---------------------------------------------------------------------------------------------
                                    Local Database Methods
     ---------------------------------------------------------------------------------------------*/

    @Override
    public void addProductToDB(OnProductListener listener, Product product) {
        dbHelper.addProductToDB(listener, product);
    }

}
