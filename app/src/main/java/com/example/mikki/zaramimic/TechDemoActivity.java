package com.example.mikki.zaramimic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mikki.zaramimic.myaccount.MyAccountActivity;
import com.example.mikki.zaramimic.myaccount.mypaycards.PayCardsActivity;
import com.example.mikki.zaramimic.products.category.CategoryActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TechDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_demo);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_asyntask, R.id.btn_recyclerview, R.id.btn_listview, R.id.btn_mvp, R.id.btn_volley, R.id.btn_cardview, R.id.btn_sqldatabase, R.id.btn_sp, R.id.btn_material, R.id.btn_paypal, R.id.btn_github, R.id.btn_language, R.id.btn_dagger, R.id.btn_butterknife})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_asyntask:
                intent = new Intent(this, CategoryActivity.class);
                break;
            case R.id.btn_recyclerview:
                intent = new Intent(this, CategoryActivity.class);
                break;
            case R.id.btn_listview:
                intent = new Intent(this, CategoryActivity.class);
                break;
            case R.id.btn_mvp:
                intent = new Intent(this, CategoryActivity.class);
                break;
            case R.id.btn_volley:
                intent = new Intent(this, CategoryActivity.class);
                break;
            case R.id.btn_cardview:
                intent = new Intent(this, CategoryActivity.class);
                break;
            case R.id.btn_sqldatabase:
                intent = new Intent(this, CategoryActivity.class);
                break;
            case R.id.btn_sp:
                intent = new Intent(this, CategoryActivity.class);
                break;
            case R.id.btn_material:
                intent = new Intent(this, CategoryActivity.class);
                break;
            case R.id.btn_paypal:
                intent = new Intent(this, PayCardsActivity.class);
                break;
            case R.id.btn_github:
                break;
            case R.id.btn_language:
                intent = new Intent(this, MyAccountActivity.class);
                break;
            case R.id.btn_dagger:
                intent = new Intent(this, CategoryActivity.class);
                break;
            case R.id.btn_butterknife:
                intent = new Intent(this, CategoryActivity.class);
                break;
        }
        startActivity(intent);
    }
}
