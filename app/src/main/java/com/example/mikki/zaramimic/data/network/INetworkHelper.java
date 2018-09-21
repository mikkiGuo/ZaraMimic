package com.example.mikki.zaramimic.data.network;

import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Category;

import java.util.List;


public interface INetworkHelper {
    public void getCategoriesFromServer(IDataManager.OnCategoriesListener listener);

    //following methods is to test mvp framework connections.
    public void testDb(IDataManager.OnCategoriesListener listener);
}
