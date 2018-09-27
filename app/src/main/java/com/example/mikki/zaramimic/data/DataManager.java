package com.example.mikki.zaramimic.data;

import android.content.Context;

import com.example.mikki.zaramimic.data.database.DbHelper;
import com.example.mikki.zaramimic.data.database.IDbHelper;
import com.example.mikki.zaramimic.data.network.INetworkHelper;
import com.example.mikki.zaramimic.data.network.NetworkHelper;
import com.example.mikki.zaramimic.data.network.model.Login;
import com.example.mikki.zaramimic.data.network.model.Order;
import com.example.mikki.zaramimic.data.network.model.Product;
import com.example.mikki.zaramimic.data.network.model.UserProfile;

import java.util.List;


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

    @Override
    public void checkout(OnOrderListener listener, List<Order> orderItemList) {
        networkHelper.checkout(listener, orderItemList);
    }


    /*---------------------------------------------------------------------------------------------
                                    Local Database Methods
     ---------------------------------------------------------------------------------------------*/

    @Override
    public void addProductToShoppingCartDB(OnProductListener listener, Product product) {
        dbHelper.addProductToShoppingCartDB(listener, product);
    }

    @Override
    public void readProductListFromShoppingCartDB(OnShoppingCartListener listener) {
        dbHelper.readProductListFromShoppingCartDB(listener);
    }

    @Override
    public void deleteProductFromShoppingCartDB(OnShoppingCartListener listener, Product product) {
        dbHelper.deleteProductFromShoppingCartDB(listener, product);
    }


    @Override
    public void addProductToWishListDB(OnProductListener listener, Product product) {
        dbHelper.addProductToWishListDB(listener, product);
    }

    @Override
    public void readProductsFromWishListDB(OnWishListListener listener) {
        dbHelper.readProductsFromWishListDB(listener);
    }

    @Override
    public void updateUserProfileDB(OnProfileUpdateListener listener) {
        dbHelper.updateUserProfileDB(listener);
    }

    @Override
    public void getProductsFromShoppingCartDB(OnOrderListener listener) {
        dbHelper.getProductsFromShoppingCartDB(listener);
    }

}
