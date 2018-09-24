package com.example.mikki.zaramimic.myaccount;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.myaccount.orderhistory.OrderHistoryActivity;
import com.example.mikki.zaramimic.myaccount.profile.MyProfileActivity;

public class MyAccountPresenter implements IMyAccountPresenter {

    IMyAccountView iMyAccountView;
    Context context;
    public MyAccountPresenter(MyAccountActivity myAccountActivity) {
        iMyAccountView = myAccountActivity;
        context = myAccountActivity;
    }


    @Override
    public void onViewClickHandler(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_myacct_ordersplaced:
                intent = new Intent(context, OrderHistoryActivity.class);
                break;

            case R.id.btn_myacct_myinfo:
                intent = new Intent(context, MyProfileActivity.class);
                break;

            case R.id.btn_myacct_paycards:
                break;

            case R.id.btn_myacct_contactus:
                break;
            case R.id.btn_myacct_help:
                break;
            case R.id.btn_myacct_settings:
                break;
            case R.id.btn_logout:
                break;
        }
        context.startActivity(intent);
    }
}
