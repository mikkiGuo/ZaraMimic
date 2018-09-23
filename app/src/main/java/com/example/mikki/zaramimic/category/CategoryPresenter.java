package com.example.mikki.zaramimic.category;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Category;
import com.example.mikki.zaramimic.main.MainActivity;

import java.util.List;

public class CategoryPresenter implements ICategoryPresenter, IDataManager.OnCategoriesListener, CategoryListAdapter.OnItemClickListener {

    ICategoryView iCategoryView;
    IDataManager iDataManager;
    Context context;

    public CategoryPresenter(CategoryActivity categoryActivity) {
        iCategoryView = categoryActivity;
        iDataManager = new DataManager(categoryActivity);
        context = categoryActivity;
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

    @Override
    public CategoryListAdapter.OnItemClickListener getItemClickListener() {
        return this;
    }


    @Override
    public void onItemClick(Category category) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }


    //below method is for testing purpose
    @Override
    public void connectToSever() {

    }
}
