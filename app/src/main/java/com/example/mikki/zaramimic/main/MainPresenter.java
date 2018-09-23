package com.example.mikki.zaramimic.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.category.CategoryActivity;
import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Category;
import com.example.mikki.zaramimic.forgotpw.ForgotPWActivity;
import com.example.mikki.zaramimic.login.LoginActivity;
import com.example.mikki.zaramimic.productlist.ProductListActivity;
import com.example.mikki.zaramimic.signup.SignUpActivity;

import java.util.List;

public class MainPresenter implements IMainPresenter, IDataManager.OnResponseListener {

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
                default:
                    break;
        }
        context.startActivity(intent);
    }

    @Override
    public void onActivityCreated() {
        
    }

    /**
     * below functionalites is for testing the connection of mvp framework
     */
    @Override
    public void connectToDb() {
        iMainView.showToast();
    }
}
