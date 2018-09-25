package com.example.mikki.zaramimic.shoppingcart;

import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Product;

import java.util.List;

public class ShoppingCartPresenter implements IShoppingCartPresenter, IDataManager.OnShoppingCartListener {

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
    public void bindProductListFromDBToView(List<Product> productList) {
        iShoppingCartView.showListOnView(productList);
    }
}
