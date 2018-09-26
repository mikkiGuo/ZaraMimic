package com.example.mikki.zaramimic.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.authentication.login.LoginActivity;
import com.example.mikki.zaramimic.products.category.CategoryActivity;

import butterknife.ButterKnife;

import static com.example.mikki.zaramimic.data.network.NetworkHelper.sharedPreferences;

public class MainActivity extends AppCompatActivity implements IMainView {

    IMainPresenter iMainPresenter;

    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        iMainPresenter = new MainPresenter(this);

        String apiKey = sharedPreferences.getString("api_key", "");
        Log.d("apikey", "onCreate: "+apiKey);
        if(apiKey == ""){
            intent = new Intent(this, LoginActivity.class);
        }else{
            intent = new Intent(this, CategoryActivity.class);
        }
        startActivity(intent);

    }

}
