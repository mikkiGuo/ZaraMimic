package com.example.mikki.zaramimic.wishlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WishListActivity extends AppCompatActivity implements IWishListView {

    IWishListPresenter iWishListPresenter;
    RecyclerView.Adapter adapter;

    @BindView(R.id.rv_wishlist)
    RecyclerView rvWishlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
        ButterKnife.bind(this);

        iWishListPresenter = new WishListPresenter(this);
        iWishListPresenter.onActivityCreated();


    }

    @Override
    public void showListOnView(List<Product> productList) {
        Toast.makeText(this, "" + productList.get(0).getPname(), Toast.LENGTH_SHORT).show();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvWishlist.setLayoutManager(layoutManager);
        rvWishlist.setItemAnimator(new DefaultItemAnimator());

        adapter = new WishListAdapter(productList);
        rvWishlist.setAdapter(adapter);
    }
}
