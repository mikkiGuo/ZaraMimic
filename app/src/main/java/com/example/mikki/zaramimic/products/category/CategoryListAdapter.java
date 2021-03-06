package com.example.mikki.zaramimic.products.category;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.MyViewHolder>{

    public interface OnItemClickListener{
        void onItemClick(Category category);
    }

    private  List<Category> categoryList;
    private OnItemClickListener listener;

    public CategoryListAdapter(List<Category> list, OnItemClickListener listener) {
        categoryList = list;
        this.listener = listener;
    }


    @NonNull
    @Override
    //where we going to create the view holder, and set layout, etc
    //ViewGroup == xml, view == button.
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,
                parent,false);

        return new MyViewHolder(rootView);
    }

    @Override
    //bind data with the holder
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(categoryList.get(position).getCname());
        String img_url = categoryList.get(position).getCimagerl();
        Picasso.get().load(img_url).into(holder.img_category);
        holder.bind(categoryList.get(position), listener);
    }

    @Override
    //get the size of list
    public int getItemCount() {
        return categoryList.size();
    }


    //holding the item and the view.
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name;
        ImageView img_category;



        public MyViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            img_category = itemView.findViewById(R.id.img_category);
        }

        public void bind(final Category category, final OnItemClickListener listener){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(category);

                }
            });
        }


    }


}
