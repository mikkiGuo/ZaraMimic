package com.example.mikki.zaramimic.myaccount;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.mikki.zaramimic.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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



    }

    @OnClick({R.id.btn_myacct_ordersplaced, R.id.btn_myacct_myinfo, R.id.btn_myacct_paycards, R.id.btn_myacct_contactus, R.id.btn_myacct_help, R.id.btn_myacct_settings, R.id.btn_logout})
    public void onViewClicked(View view) {

        iMyAccountPresenter.onViewClickHandler(view);

    }
}
