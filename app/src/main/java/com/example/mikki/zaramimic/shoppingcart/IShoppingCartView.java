package com.example.mikki.zaramimic.shoppingcart;

import com.example.mikki.zaramimic.data.network.model.Product;

import java.util.List;

public interface IShoppingCartView {

    public void showListOnView(List<Product> productList);
}
