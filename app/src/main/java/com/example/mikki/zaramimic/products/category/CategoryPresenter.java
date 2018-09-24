package com.example.mikki.zaramimic.products.category;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.mikki.zaramimic.products.subcategory.SubCategoryActivity;
import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Category;

import java.util.List;

import static com.example.mikki.zaramimic.data.network.NetworkHelper.sharedPreferences;

public class CategoryPresenter implements ICategoryPresenter, IDataManager.OnCategoriesListener
{

    ICategoryView iCategoryView;
    IDataManager iDataManager;

    public CategoryPresenter(CategoryActivity categoryActivity) {
        iCategoryView = categoryActivity;
        iDataManager = new DataManager(categoryActivity);
    }


    @Override
    public void onActivityCreated() {
        //at the start of activity, load the category class from server
        iDataManager.getCategoriesFromServer(this);

    }

    @Override
    public void bindCategoriesToView(List<Category> categoryList) {

        Log.d("show", "bindCategoriesToView: " + categoryList.get(0).getCname());

        iCategoryView.showCategoryList(categoryList);

    }


}
