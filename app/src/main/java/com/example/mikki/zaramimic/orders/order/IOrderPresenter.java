package com.example.mikki.zaramimic.orders.order;

import com.example.mikki.zaramimic.data.network.model.Order;

import java.util.List;

public interface IOrderPresenter {

    void getShoppingCartInfo();
    void checkout(List<Order> orderItemList);
}
