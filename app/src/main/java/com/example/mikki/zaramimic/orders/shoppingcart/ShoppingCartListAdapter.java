package com.example.mikki.zaramimic.orders.shoppingcart;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShoppingCartListAdapter extends RecyclerView.Adapter<ShoppingCartListAdapter.MyViewHolder>{

    private static final String TAG = "ShoppingCartListAdapter";
    IShoppingCartPresenter iShoppingCartPresenter;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onDeleteClick(Product product);
    }

    private List<Product> productList;

    public ShoppingCartListAdapter(List<Product> list, OnItemClickListener listener) {

        productList = list;
        this.listener = listener;
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

        int order_quantity = productList.get(position).getOrder_quantity();
        int quantity = Integer.parseInt(productList.get(position).getQuantity());
        Log.d(TAG, "onBindViewHolder: " + quantity);
        String prize = productList.get(position).getPrize();
        int price = Integer.parseInt(prize);
        int total = order_quantity * price;
        //int total = quantity * price;
        holder.tv_quantity_price.setText(String.valueOf(order_quantity) + " x "+ prize + " USD");
        //holder.tv_quantity_price.setText(String.valueOf(quantity) + " x "+ prize + " USD");
        holder.tv_totalprice.setText(String.valueOf(total) + " USD");

        holder.bind(productList.get(position), listener);

    }

    @Override
    //get the size of list
    public int getItemCount() {
        return productList.size();
    }


    //holding the item and the view.
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name, tv_quantity_price, tv_totalprice, tv_delete;
        ImageView img_cart_item;


        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_cart_item_name);
            tv_quantity_price = itemView.findViewById(R.id.tv_cart_item_quanprice);
            tv_totalprice = itemView.findViewById(R.id.tv_cart_item_totalprice);
            img_cart_item = itemView.findViewById(R.id.img_cart_item);
            tv_delete = itemView.findViewById(R.id.tv_delete);
        }

        public void bind(final Product product, final OnItemClickListener listener){

            tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productList.remove(getAdapterPosition());
                    notifyDataSetChanged();
                    listener.onDeleteClick(product);

                }
            });
        }


    }
}
