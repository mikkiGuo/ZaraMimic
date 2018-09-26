package com.example.mikki.zaramimic.orders.shoppingcart;

import com.example.mikki.zaramimic.data.network.model.Product;

public interface IShoppingCartPresenter {

    void onActivityCreated();

    void onDeleteClickHandler(Product product);
}
