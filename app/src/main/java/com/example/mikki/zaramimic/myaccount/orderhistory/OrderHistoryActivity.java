package com.example.mikki.zaramimic.myaccount.orderhistory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.OrderHistory;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderHistoryActivity extends AppCompatActivity implements IOrderHistoryView {

    IOrderHistoryPresenter iOrderHistoryPresenter;

    @BindView(R.id.rv_orderhistory)
    RecyclerView rvOrderhistory;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        ButterKnife.bind(this);

        iOrderHistoryPresenter = new OrderHistoryPresenter(this);
        iOrderHistoryPresenter.onActivityCreate();

    }


    @Override
    public void showCategoryList(List<OrderHistory> orderHistoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvOrderhistory.setLayoutManager(layoutManager);
        rvOrderhistory.setItemAnimator(new DefaultItemAnimator());

        OrderHistory orders = orderHistoryList.get(0);
        Log.d("show", "showCategoryList: " + orders.getItemname());
        adapter = new OrderHistoryAdapter(orderHistoryList, new OrderHistoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(OrderHistory orderHistory) {
                Toast.makeText(OrderHistoryActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
        rvOrderhistory.setAdapter(adapter);
    }
}
