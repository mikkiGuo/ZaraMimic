package com.example.mikki.zaramimic.products.productlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder>
{
    public interface OnProductItemClickListener{
        void onItemClick(Product product);
    }

    List<Product> productList;
    private OnProductItemClickListener listener;

    public ProductListAdapter(List<Product> list, OnProductItemClickListener listener) {
        this.productList = list;
        this.listener = listener;
    }


    @NonNull
    @Override
    //where we going to create the view holder, and set layout, etc
    //ViewGroup == xml, view == button.
    public ProductListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,
                parent,false);

        return new ProductListAdapter.MyViewHolder(rootView);
    }

    @Override
    //bind data with the holder
    public void onBindViewHolder(@NonNull ProductListAdapter.MyViewHolder holder, int position) {
        String img_url = productList.get(position).getImage();
        Picasso.get().load(img_url).into(holder.pImage);
        holder.pName.setText(productList.get(position).getPname());
        holder.pPrice.setText(productList.get(position).getPrize() + " USD");
        holder.bind(productList.get(position), listener);
    }

    @Override
    //get the size of list
    public int getItemCount() {
        return productList.size();
    }


    //holding the item and the view.
    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView pImage;
        TextView pName, pPrice;

        public MyViewHolder(View itemView) {
            super(itemView);

            pImage = itemView.findViewById(R.id.img_product);
            pName = itemView.findViewById(R.id.tv_pname);
            pPrice = itemView.findViewById(R.id.tv_price);

        }

        public void bind(final Product product, final OnProductItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(product);
                }
            });
        }


    }



}
