package com.example.mikki.zaramimic.myaccount.orderhistory;

import com.example.mikki.zaramimic.data.network.model.OrderHistory;

import java.util.List;

public interface IOrderHistoryView {
    void showCategoryList(List<OrderHistory> orderHistoryList);
}
