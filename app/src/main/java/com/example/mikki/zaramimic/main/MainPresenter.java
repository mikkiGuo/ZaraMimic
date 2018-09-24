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
    Context context;

    public MainPresenter(MainActivity mainActivity) {
        iMainView = mainActivity;
        iDataManager = new DataManager(mainActivity);
        context = mainActivity;
    }


    @Override
    public void onButtonClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_category:
                intent = new Intent(context, CategoryActivity.class);
                break;
            case R.id.btn_product:
                intent = new Intent(context, ProductListActivity.class);
                break;
            case R.id.btn_mtologin:
                intent = new Intent(context, LoginActivity.class);
                break;
            case R.id.btn_mtosignup:
                intent = new Intent(context, SignUpActivity.class);
                break;
            case R.id.btn_toforgot:
                intent = new Intent(context, ForgotPWActivity.class);
                break;
            case R.id.btn_mtomyacct:
                intent = new Intent(context, MyAccountActivity.class);
                default:
                    break;
        }
        context.startActivity(intent);
    }



}
