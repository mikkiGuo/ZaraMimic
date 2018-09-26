package com.example.mikki.zaramimic.products.productlist;

import com.example.mikki.zaramimic.data.network.model.Product;

import java.util.List;

public interface IProductListView {

    void showToast(String s);
    void showProductList(List<Product> productList);

}
