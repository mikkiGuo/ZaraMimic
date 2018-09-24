package com.example.mikki.zaramimic.products.subcategory;

import android.content.Context;

import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.SubCategory;

import java.util.List;

public class SubCategoryPresenter implements ISubCategoryPresenter, IDataManager.OnSubCategoriesListener{
    private static final String TAG = "SubCategoryPresenter";

    ISubCategoryView iSubCategoryView;
    Context context;
    IDataManager iDataManager;

    public SubCategoryPresenter(SubCategoryActivity subCategoryActivity) {
        iSubCategoryView = subCategoryActivity;
        context = subCategoryActivity;
        iDataManager = new DataManager(subCategoryActivity);
    }


    @Override
    public void onActivityCreated() {
        iDataManager.getSubCategoriesFromServer(this);
    }

    @Override
    public void bindSubCategoriesToView(List<SubCategory> subCategories) {

        iSubCategoryView.showSubCategoyList(subCategories);

    }
}
