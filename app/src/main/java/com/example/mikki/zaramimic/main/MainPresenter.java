package com.example.mikki.zaramimic.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.products.category.CategoryActivity;
import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.authentication.forgotpw.ForgotPWActivity;
import com.example.mikki.zaramimic.authentication.login.LoginActivity;
import com.example.mikki.zaramimic.myaccount.MyAccountActivity;
import com.example.mikki.zaramimic.products.productlist.ProductListActivity;
import com.example.mikki.zaramimic.authentication.signup.SignUpActivity;

public class MainPresenter implements IMainPresenter {

    IMainView iMainView;
    IDataManager iDataManager;


    public MainPresenter(MainActivity mainActivity) {
        iMainView = mainActivity;
        iDataManager = new DataManager(mainActivity);
    }




}
