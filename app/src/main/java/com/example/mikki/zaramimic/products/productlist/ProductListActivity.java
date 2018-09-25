package com.example.mikki.zaramimic.products.productlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.Product;
import com.example.mikki.zaramimic.products.productpage.ProductPageActivity;
import com.example.mikki.zaramimic.shoppingcart.ShoppingCartActivity;
import com.example.mikki.zaramimic.wishlist.WishListActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductListActivity extends AppCompatActivity implements IProductListView {

    private static final String TAG = "ProductListActivity";
    IProductListPresenter iProductListPresenter;
    Adapter adapter;

    @BindView(R.id.rv_productlist)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        ButterKnife.bind(this);

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
        Toast.makeText(this, "" + s, Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.icon_back, R.id.icon_search, R.id.icon_towishlist, R.id.icon_tocart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.icon_back:
                finish();
                break;
            case R.id.icon_search:
                break;
            case R.id.icon_towishlist:
                Intent intent = new Intent(ProductListActivity.this, WishListActivity.class);
                startActivity(intent);
                break;
            case R.id.icon_tocart:
                Intent intent1 = new Intent(ProductListActivity.this, ShoppingCartActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
