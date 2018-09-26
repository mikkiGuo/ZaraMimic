package com.example.mikki.zaramimic.orders.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.Product;
import com.example.mikki.zaramimic.orders.order.OrderActivity;
import com.example.mikki.zaramimic.orders.orderconfirmation.OrderConfirmActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShoppingCartActivity extends AppCompatActivity implements IShoppingCartView {

    IShoppingCartPresenter iShoppingCartPresenter;
    @BindView(R.id.rv_shopcart)
    RecyclerView rvShopcart;
    RecyclerView.Adapter adapter;
    @BindView(R.id.tv_sp_total)
    TextView tvSpTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        ButterKnife.bind(this);
        iShoppingCartPresenter = new ShoppingCartPresenter(this);
        iShoppingCartPresenter.onActivityCreated();


    }

    @Override
    public void showListOnView(List<Product> productList) {
        //Toast.makeText(this, "" + productList.get(0).getPname(), Toast.LENGTH_SHORT).show();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvShopcart.setLayoutManager(layoutManager);
        rvShopcart.setItemAnimator(new DefaultItemAnimator());

        adapter = new ShoppingCartListAdapter(productList, new ShoppingCartListAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(Product product) {
                iShoppingCartPresenter.onDeleteClickHandler(product);
            }
        });

        rvShopcart.setAdapter(adapter);

    }

    @OnClick({R.id.icon_close, R.id.tv_cart_edit, R.id.btn_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.icon_close:
                finish();
                break;
            case R.id.tv_cart_edit:
                break;
            case R.id.btn_buy:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                break;
        }
    }


}
