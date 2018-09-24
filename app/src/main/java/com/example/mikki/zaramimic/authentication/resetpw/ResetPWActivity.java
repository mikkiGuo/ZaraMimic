package com.example.mikki.zaramimic.authentication.resetpw;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mikki.zaramimic.R;

import butterknife.ButterKnife;

public class ResetPWActivity extends AppCompatActivity implements IResetPWView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pw);
        ButterKnife.bind(this);
        Uri data = getIntent().getData();

    }
}
