package com.example.mikki.zaramimic.productlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mikki.zaramimic.R;

public class ProductListActivity extends AppCompatActivity implements IProductListView {

    IProductListPresenter iProductListPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        iProductListPresenter = new ProductListPresenter(this);
        iProductListPresenter.onActivityCreated();

    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }
}
