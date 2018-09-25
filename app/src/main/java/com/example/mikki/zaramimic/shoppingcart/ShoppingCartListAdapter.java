package com.example.mikki.zaramimic.shoppingcart;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.Category;
import com.example.mikki.zaramimic.data.network.model.Product;
import com.example.mikki.zaramimic.products.category.CategoryListAdapter;
import com.example.mikki.zaramimic.products.productlist.ProductListAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShoppingCartListAdapter extends RecyclerView.Adapter<ShoppingCartListAdapter.MyViewHolder>{


    private List<Product> productList;

    public ShoppingCartListAdapter(List<Product> list) {
        productList = list;
    }


    @NonNull
    @Override
    //where we going to create the view holder, and set layout, etc
    //ViewGroup == xml, view == button.
    public ShoppingCartListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shopcart,
                parent,false);

        return new ShoppingCartListAdapter.MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String img_url = productList.get(position).getImage();
        Picasso.get().load(img_url).into(holder.img_cart_item);
        holder.tv_name.setText(productList.get(position).getPname());
        holder.tv_quantity_price.setText(productList.get(position).getQuantity());
        holder.tv_totalprice.setText(productList.get(position).getPrize());

    }


    @Override
    //get the size of list
    public int getItemCount() {
        return productList.size();
    }


    //holding the item and the view.
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name, tv_quantity_price, tv_totalprice;
        ImageView img_cart_item;


        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_cart_item_name);
            tv_quantity_price = itemView.findViewById(R.id.tv_cart_item_quanprice);
            tv_totalprice = itemView.findViewById(R.id.tv_cart_item_totalprice);
            img_cart_item = itemView.findViewById(R.id.img_cart_item);
        }


    }
}
