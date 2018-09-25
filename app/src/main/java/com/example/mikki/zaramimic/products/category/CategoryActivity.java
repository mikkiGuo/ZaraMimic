package com.example.mikki.zaramimic.products.category;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.authentication.login.LoginActivity;
import com.example.mikki.zaramimic.data.network.model.Category;
import com.example.mikki.zaramimic.products.subcategory.SubCategoryActivity;
import com.example.mikki.zaramimic.shoppingcart.ShoppingCartActivity;
import com.example.mikki.zaramimic.wishlist.WishListActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mikki.zaramimic.data.network.NetworkHelper.sharedPreferences;

public class CategoryActivity extends AppCompatActivity implements ICategoryView {

    ICategoryPresenter iCategoryPresenter;
    Adapter adapter;

    @BindView(R.id.rv_category_list)
    RecyclerView rvCategoryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);

        iCategoryPresenter = new CategoryPresenter(this);

        iCategoryPresenter.onActivityCreated();

    }

    /**
     * show categories on View by using adapter and recycler list view.
     *
     * @param categoryList
     */
    @Override
    public void showCategoryList(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvCategoryList.setLayoutManager(layoutManager);
        rvCategoryList.setItemAnimator(new DefaultItemAnimator());

        Category c = categoryList.get(0);
        Log.d("show", "showCategoryList: " + c.getCname());
        adapter = new CategoryListAdapter(categoryList, new CategoryListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Category category) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("cid", category.getCid());
                editor.commit();
                Intent intent = new Intent(CategoryActivity.this, SubCategoryActivity.class);
                startActivity(intent);
            }
        });
        rvCategoryList.setAdapter(adapter);

        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();

    }

    @OnClick({R.id.tv_logout,R.id.icon_search, R.id.icon_towishlist, R.id.icon_tocart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_logout:
                sharedPreferences.edit().clear().commit();
                Intent intent2 = new Intent(CategoryActivity.this, LoginActivity.class);
                startActivity(intent2);
                break;
            case R.id.icon_search:
                break;
            case R.id.icon_towishlist:
                Intent intent = new Intent(CategoryActivity.this, WishListActivity.class);
                startActivity(intent);
                break;
            case R.id.icon_tocart:
                Intent intent1 = new Intent(CategoryActivity.this, ShoppingCartActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
