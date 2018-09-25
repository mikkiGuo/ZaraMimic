package com.example.mikki.zaramimic.data.database;

import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Product;


public interface IDbHelper {

    public void addProductToShoppingCartDB(IDataManager.OnProductListener listener, Product product);
    public void readProductListFromShoppingCartDB(IDataManager.OnShoppingCartListener listener);
    public void deleteProductFromShoppingCartDB(IDataManager.OnShoppingCartListener listener);

    public void addProductToWishListDB(IDataManager.OnProductListener listener, Product product);
    public void readProductsFromWishListDB(IDataManager.OnWishListListener listener);

}
