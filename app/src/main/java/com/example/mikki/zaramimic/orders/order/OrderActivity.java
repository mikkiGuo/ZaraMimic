package com.example.mikki.zaramimic.orders.order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mikki.zaramimic.R;

public class OrderActivity extends AppCompatActivity implements IOrderView {

    IOrderPresenter iOrderPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        iOrderPresenter = new OrderPresenter(this);
        iOrderPresenter.onActivityCreate();


    }
}
