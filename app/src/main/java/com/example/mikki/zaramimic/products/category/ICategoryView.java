package com.example.mikki.zaramimic.products.category;

import android.app.Fragment;

import com.example.mikki.zaramimic.data.network.model.Category;

import java.util.List;

public interface ICategoryView {

    void showCategoryList(List<Category> categoryList);

}
