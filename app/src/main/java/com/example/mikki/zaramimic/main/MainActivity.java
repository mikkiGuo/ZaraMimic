package com.example.mikki.zaramimic.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.authentication.login.LoginActivity;
import com.example.mikki.zaramimic.products.category.CategoryActivity;
import com.example.mikki.zaramimic.shoppingcart.ShoppingCartActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

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
        if(apiKey == null){
             intent = new Intent(this, LoginActivity.class);
        }else{
            intent = new Intent(this, CategoryActivity.class);
        }
        startActivity(intent);

    }

    //below functinalities is to test mvp framework
    @Override
    public void showToast() {
        Toast.makeText(this, "Connect to db successful", Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.btn_category, R.id.btn_product, R.id.btn_mtologin, R.id.btn_mtosignup, R.id.btn_toforgot, R.id.btn_mtomyacct, R.id.btn_mtocart})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_category:
                break;
            case R.id.btn_product:
                break;
            case R.id.btn_mtologin:
                break;
            case R.id.btn_mtosignup:
                break;
            case R.id.btn_toforgot:
                break;
            case R.id.btn_mtomyacct:
                break;
            case R.id.btn_mtocart:
                intent = new Intent(this, ShoppingCartActivity.class);
                break;
        }
        startActivity(intent);
    }
}
