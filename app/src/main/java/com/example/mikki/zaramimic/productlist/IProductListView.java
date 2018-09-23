package com.example.mikki.zaramimic.productlist;

import com.example.mikki.zaramimic.data.network.model.Product;

import java.util.List;

public interface IProductListView {

    public void showToast(String s);
    public void showProductList(List<Product> productList);

}
