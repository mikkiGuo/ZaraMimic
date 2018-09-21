package com.example.mikki.zaramimic.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.category.CategoryActivity;

public class MainActivity extends AppCompatActivity implements IMainView{

    IMainPresenter iMainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iMainPresenter = new MainPresenter(this);
        iMainPresenter.onActivityCreated();


    }

    //below functinalities is to test mvp framework
    @Override
    public void showToast() {
        Toast.makeText(this, "Connect to db successful", Toast.LENGTH_SHORT).show();
    }
    public void onClickHandler(View view) {
        iMainPresenter.onButtonClicked(view);
    }
}
