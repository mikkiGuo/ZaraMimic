package com.example.mikki.zaramimic.data.database;

import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Product;


public interface IDbHelper {
    public void addProductToDB(IDataManager.OnProductListener listener, Product product);

}
