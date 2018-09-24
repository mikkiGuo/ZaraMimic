package com.example.mikki.zaramimic.products.productlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.widget.Toast;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.Product;
import com.example.mikki.zaramimic.products.productpage.ProductPageActivity;

import java.util.List;

public class ProductListActivity extends AppCompatActivity implements IProductListView {

    private static final String TAG = "ProductListActivity";
    IProductListPresenter iProductListPresenter;

    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        iProductListPresenter = new ProductListPresenter(this);
        iProductListPresenter.onActivityCreated();
        recyclerView = findViewById(R.id.rv_productlist);

    }


    @Override
    public void showProductList(List<Product> productList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Product p = productList.get(0);
        Log.d(TAG, "showCategoryList: " + p.getPname());
        adapter = new ProductListAdapter(productList, new ProductListAdapter.OnProductItemClickListener() {
            @Override
            public void onItemClick(Product product) {
                Intent intent = new Intent(ProductListActivity.this, ProductPageActivity.class);
                intent.putExtra("product_item", product);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void showToast(String s) {
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }


}
