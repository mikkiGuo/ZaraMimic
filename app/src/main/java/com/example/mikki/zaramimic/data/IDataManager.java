package com.example.mikki.zaramimic.data;

import com.example.mikki.zaramimic.data.database.IDbHelper;
import com.example.mikki.zaramimic.data.database.model.TodoNote;
import com.example.mikki.zaramimic.data.network.INetworkHelper;
import com.example.mikki.zaramimic.data.network.model.Category;

import java.util.List;


public interface IDataManager extends IDbHelper, INetworkHelper {

    interface OnResponseListener{ /// switch board
        public void connectToDb();
    }

    interface OnCategoriesListener{

        public void bindCategoriesToView(List<Category> categoryList);

        //below methods is to test mvp framework connections.
        public void connectToSever();
    }
}
