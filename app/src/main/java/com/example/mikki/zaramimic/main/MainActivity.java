package com.example.mikki.zaramimic.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.mikki.zaramimic.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMainView {

    IMainPresenter iMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        iMainPresenter = new MainPresenter(this);
        //iMainPresenter.onActivityCreated();


    }

    //below functinalities is to test mvp framework
    @Override
    public void showToast() {
        Toast.makeText(this, "Connect to db successful", Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.btn_category, R.id.btn_product, R.id.btn_mtologin, R.id.btn_mtosignup, R.id.btn_toforgot})
    public void onViewClicked(View view) {
        iMainPresenter.onButtonClicked(view);

    }

}
