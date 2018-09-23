package com.example.mikki.zaramimic.category;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.widget.Toast;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.Category;
import com.example.mikki.zaramimic.main.MainActivity;
import com.example.mikki.zaramimic.productlist.ProductListActivity;

import java.util.List;

public class CategoryActivity extends AppCompatActivity implements ICategoryView{

    ICategoryPresenter iCategoryPresenter;

    RecyclerView recyclerView;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        recyclerView = findViewById(R.id.rv_category_list);
        iCategoryPresenter = new CategoryPresenter(this);
        iCategoryPresenter.onActivityCreated();

    }

    /**
     * show categories on View by using adapter and recycler list view.
     * @param categoryList
     */
    @Override
    public void showCategoryList(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Category c = categoryList.get(0);
        Log.d("show", "showCategoryList: " + c.getCname());
        adapter = new CategoryListAdapter(categoryList, iCategoryPresenter.getItemClickListener());
        recyclerView.setAdapter(adapter);

        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();

    }

}
