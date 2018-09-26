package com.example.mikki.zaramimic.orders.order;

import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;

public class OrderPresenter implements IOrderPresenter {
    IOrderView iOrderView;
    IDataManager iDataManager;
    public OrderPresenter(OrderActivity orderActivity) {
        iDataManager = new DataManager(orderActivity);
        iOrderView = orderActivity;
    }


    @Override
    public void onActivityCreate() {

    }
}
