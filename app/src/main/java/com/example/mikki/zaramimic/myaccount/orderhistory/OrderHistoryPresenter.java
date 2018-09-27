package com.example.mikki.zaramimic.myaccount.orderhistory;

import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.OrderHistory;

import java.util.List;

public class OrderHistoryPresenter implements IOrderHistoryPresenter, IDataManager.OnOrderHistoryListener {

    IOrderHistoryView iOrderHistoryView;
    IDataManager iDataManager;

    public OrderHistoryPresenter(OrderHistoryActivity orderHistoryActivity) {
        iOrderHistoryView = orderHistoryActivity;

        iDataManager = new DataManager(orderHistoryActivity);

    }

    @Override
    public void onActivityCreate() {
        iDataManager.getOrderHistoryFromServer(this);
    }

    @Override
    public void bindOrderHistoryToView(List<OrderHistory> orderHistoryList) {
        iOrderHistoryView.showCategoryList(orderHistoryList);
    }
}
