package com.example.mikki.zaramimic.products.subcategory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.SubCategory;
import com.example.mikki.zaramimic.products.productlist.ProductListActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.mikki.zaramimic.data.network.NetworkHelper.sharedPreferences;

public class ListAdapter extends BaseAdapter {
    List<SubCategory> subCategoryList = new ArrayList<>();
    Context cxt;
    LayoutInflater myLayout;

    public ListAdapter(List<SubCategory> subCategoryList, Context cxt) {
        this.subCategoryList = subCategoryList;
        this.cxt = cxt;
        myLayout = (LayoutInflater) cxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return subCategoryList.size();
    }

    @Override
    public Object getItem(int i) {
        return subCategoryList.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view1 = myLayout.inflate(R.layout.item_subcategory, null);
        TextView scName = view1.findViewById(R.id.tv_subcatitem);

        scName.setText(subCategoryList.get(i).getScname());

        scName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String scid = subCategoryList.get(i).getScid();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("scid", scid);
                editor.commit();

                Intent intent = new Intent(cxt, ProductListActivity.class);
                cxt.startActivity(intent);
            }
        });

        return view1;
    }
}