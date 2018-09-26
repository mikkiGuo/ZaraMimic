package com.example.mikki.zaramimic.orders.shoppingcart;

import android.view.View;

import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Product;

import java.util.List;

public class ShoppingCartPresenter implements IShoppingCartPresenter,
        IDataManager.OnShoppingCartListener, View.OnClickListener {

    IShoppingCartView iShoppingCartView;
    IDataManager iDataManager;

    public ShoppingCartPresenter(ShoppingCartActivity shoppingCartActivity) {
        iShoppingCartView = shoppingCartActivity;
        iDataManager = new DataManager(shoppingCartActivity);
    }


    @Override
    public void onActivityCreated() {
        iDataManager.readProductListFromShoppingCartDB(this);
    }

    @Override
    public void onDeleteClickHandler(Product product) {
        iDataManager.deleteProductFromShoppingCartDB(this, product);
    }

    @Override
    public void bindProductListFromDBToView(List<Product> productList) {
        iShoppingCartView.showListOnView(productList);
    }

    @Override
    public void isProductDeleted(boolean result) {

    }

    @Override
    public void onClick(View v) {

    }
}
