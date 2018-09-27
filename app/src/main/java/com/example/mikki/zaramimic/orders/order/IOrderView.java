package com.example.mikki.zaramimic.orders.order;

import com.example.mikki.zaramimic.data.network.model.Order;

import java.util.List;

public interface IOrderView {

    void groupInfo(List<Order> orderItemList);

    void displayStatus(String s);
}
