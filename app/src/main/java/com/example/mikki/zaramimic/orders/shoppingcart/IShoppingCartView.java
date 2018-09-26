package com.example.mikki.zaramimic.orders.shoppingcart;

import com.example.mikki.zaramimic.data.network.model.Product;

import java.util.List;

public interface IShoppingCartView {

    void showListOnView(List<Product> productList);
}
