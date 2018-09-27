package com.example.mikki.zaramimic.data.database;

import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Product;


public interface IDbHelper {

    void addProductToShoppingCartDB(IDataManager.OnProductListener listener, Product product);
    void readProductListFromShoppingCartDB(IDataManager.OnShoppingCartListener listener);
    void deleteProductFromShoppingCartDB(IDataManager.OnShoppingCartListener listener, Product product);

    void addProductToWishListDB(IDataManager.OnProductListener listener, Product product);
    void readProductsFromWishListDB(IDataManager.OnWishListListener listener);

    void updateUserProfileDB(IDataManager.OnProfileUpdateListener listener);

    void getProductsFromShoppingCartDB(IDataManager.OnOrderListener onOrderListener);
}
