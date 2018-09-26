package com.example.mikki.zaramimic.myaccount;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.authentication.login.LoginActivity;
import com.example.mikki.zaramimic.myaccount.contactus.ContactUsActivity;
import com.example.mikki.zaramimic.myaccount.mypaycards.PayCardsActivity;
import com.example.mikki.zaramimic.myaccount.orderhistory.OrderHistoryActivity;
import com.example.mikki.zaramimic.myaccount.profile.MyProfileActivity;
import com.example.mikki.zaramimic.products.category.CategoryActivity;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mikki.zaramimic.data.network.NetworkHelper.sharedPreferences;

public class MyAccountActivity extends AppCompatActivity implements IMyAccountView {


    IMyAccountPresenter iMyAccountPresenter;
    @BindView(R.id.tv_myacct_email)
    TextView tvMyacctEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        ButterKnife.bind(this);

        iMyAccountPresenter = new MyAccountPresenter(this);
        String email = sharedPreferences.getString("email", "");
        Log.d("myacct", "onCreate: " + email);
        tvMyacctEmail.setText(email);
    }


    @OnClick({R.id.icon_closepg, R.id.btn_myacct_ordersplaced, R.id.btn_myacct_myinfo,
            R.id.btn_myacct_paycards, R.id.btn_myacct_contactus, R.id.btn_myacct_help,
            R.id.btn_myacct_settings, R.id.btn_logout})
    public void onViewClicked(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.icon_closepg:
                intent = new Intent(this, CategoryActivity.class);
                break;
            case R.id.btn_myacct_ordersplaced:
                intent = new Intent(this, OrderHistoryActivity.class);
                break;
            case R.id.btn_myacct_myinfo:
                intent = new Intent(this, MyProfileActivity.class);
                break;
            case R.id.btn_myacct_paycards:
                intent = new Intent(this, PayCardsActivity.class);
                break;
            case R.id.btn_myacct_contactus:
                intent = new Intent(this, ContactUsActivity.class);
                break;
            case R.id.btn_myacct_help:
                intent = new Intent(this, ContactUsActivity.class);
                break;
            case R.id.btn_myacct_settings:
                intent = new Intent(this, ContactUsActivity.class);
                break;
            case R.id.btn_logout:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                intent = new Intent(this, LoginActivity.class);
                break;
                default:break;
        }
        startActivity(intent);
    }
}
