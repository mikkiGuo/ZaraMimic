package com.example.mikki.zaramimic.products.category;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.Category;
import com.example.mikki.zaramimic.myaccount.MyAccountActivity;
import com.example.mikki.zaramimic.orders.shoppingcart.ShoppingCartActivity;
import com.example.mikki.zaramimic.products.subcategory.SubCategoryActivity;
import com.example.mikki.zaramimic.wishlist.WishListActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import steelkiwi.com.library.DotsLoaderView;

import static com.example.mikki.zaramimic.data.network.NetworkHelper.sharedPreferences;

public class CategoryActivity extends AppCompatActivity implements ICategoryView, TabLayout.OnTabSelectedListener {

    ICategoryPresenter iCategoryPresenter;
    Adapter adapter;

    @BindView(R.id.rv_frag_category)
    RecyclerView rvCategoryList;

    @BindView(R.id.tablay_main)
    TabLayout tablayMain;
    @BindView(R.id.dotsLoader)
    DotsLoaderView dotsLoaderView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);

        iCategoryPresenter = new CategoryPresenter(this);

        tablayMain.setOnTabSelectedListener(this);
        downloadData();

    }
    private void downloadData() {
        AsyncTask<String,String,String> asyncTask = new AsyncTask<String, String, String>() {
            @Override
            protected void onPreExecute() {
                dotsLoaderView.show();
            }

            @Override
            protected String doInBackground(String... strings) {
                iCategoryPresenter.onActivityCreated();
                return "done";
            }

            @Override
            protected void onPostExecute(String s) {
                if(s.equals("done")){
                    dotsLoaderView.hide();
                }
            }
        };
        asyncTask.execute();
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

    }

    @OnClick({R.id.icon_towishlist, R.id.icon_tocart})
    public void onViewClicked(View view) {

        Intent intent1 = null;

        switch (view.getId()) {
            case R.id.icon_towishlist:
                intent1 = new Intent(CategoryActivity.this, WishListActivity.class);
                break;
            case R.id.icon_tocart:
                intent1 = new Intent(CategoryActivity.this, ShoppingCartActivity.class);
                break;

            default:
                break;
        }

        startActivity(intent1);
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        switch (position) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                Intent intent = new Intent(this, MyAccountActivity.class);
                startActivity(intent);
                break;
            default:
                break;

        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
