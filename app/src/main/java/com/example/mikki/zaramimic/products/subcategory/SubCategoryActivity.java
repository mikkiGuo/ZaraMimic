package com.example.mikki.zaramimic.products.subcategory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Adapter;
import android.widget.ListView;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.SubCategory;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubCategoryActivity extends AppCompatActivity implements ISubCategoryView {

    ISubCategoryPresenter iSubCategoryPresenter;

    @BindView(R.id.lv_subcatlist)
    ListView lvSubcatlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);
        ButterKnife.bind(this);

        iSubCategoryPresenter = new SubCategoryPresenter(this);
        iSubCategoryPresenter.onActivityCreated();


    }

    @Override
    public void showSubCategoyList(List<SubCategory> subCategoryList) {

        ListAdapter adapter = new ListAdapter(subCategoryList, this);
        lvSubcatlist.setAdapter(adapter);

    }


}
