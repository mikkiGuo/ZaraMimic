package com.example.mikki.zaramimic.products.productpage;

import com.example.mikki.zaramimic.data.network.model.Product;

public interface IProductPagePresenter {

    void onBtnAddClickHandler(Product p);
    void onWishlistClickHandler(Product p);
}
