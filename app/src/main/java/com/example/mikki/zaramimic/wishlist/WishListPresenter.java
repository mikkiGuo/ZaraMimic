package com.example.mikki.zaramimic.wishlist;

import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Product;

import java.util.List;

public class WishListPresenter implements IWishListPresenter, IDataManager.OnWishListListener {

    IWishListView iWishListView;
    IDataManager iDataManager;

    public WishListPresenter(WishListActivity wishListActivity) {
        iWishListView = wishListActivity;
        iDataManager = new DataManager(wishListActivity);

    }


    @Override
    public void onActivityCreated() {
        iDataManager.readProductsFromWishListDB(this);
    }

    @Override
    public void bindProductsFromDBtoView(List<Product> productList) {
        iWishListView.showListOnView(productList);
    }
}
