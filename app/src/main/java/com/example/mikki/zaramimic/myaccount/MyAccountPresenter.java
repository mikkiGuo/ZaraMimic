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


}
