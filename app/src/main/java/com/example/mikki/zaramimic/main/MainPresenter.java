package com.example.mikki.zaramimic.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.category.CategoryActivity;
import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Category;

import java.util.List;

public class MainPresenter implements IMainPresenter, IDataManager.OnResponseListener {

    IMainView iMainView;
    IDataManager iDataManager;
    Context context;

    public MainPresenter(MainActivity mainActivity) {
        iMainView = mainActivity;
        iDataManager = new DataManager(mainActivity);
        context = mainActivity;
    }


    @Override
    public void onButtonClicked(View view) {
        switch (view.getId()){
            case R.id.button:
                //iDataManager.createRow(this);
                //iDataManager.testDb(this);
        }
    }

    @Override
    public void onActivityCreated() {
        Intent intent = new Intent(context, CategoryActivity.class);
        context.startActivity(intent);
    }

    /**
     * below functionalites is for testing the connection of mvp framework
     */
    @Override
    public void connectToDb() {
        iMainView.showToast();
    }
}
