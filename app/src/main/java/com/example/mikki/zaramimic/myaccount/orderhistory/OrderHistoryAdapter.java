package com.example.mikki.zaramimic.myaccount.orderhistory;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.OrderHistory;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.MyViewHolder> {

    public interface OnItemClickListener{
        void onItemClick(OrderHistory orderHistory);
    }

    private List<OrderHistory> orderHistories;
    private OrderHistoryAdapter.OnItemClickListener listener;

    public OrderHistoryAdapter(List<OrderHistory> list, OrderHistoryAdapter.OnItemClickListener listener) {
        orderHistories = list;
        this.listener = listener;
    }


    @NonNull
    @Override
    //where we going to create the view holder, and set layout, etc
    //ViewGroup == xml, view == button.
    public OrderHistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_orders,
                parent,false);

        return new OrderHistoryAdapter.MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String total = orderHistories.get(position).getTotalprice();
        String address = orderHistories.get(position).getDeliveryadd();
        String purchase_date = orderHistories.get(position).getPlacedon();
        holder.tv_fprice.setText(total);
        holder.tv_delieveryadd.setText(address);
        holder.tv_date.setText(purchase_date);

    }

    @Override
    //get the size of list
    public int getItemCount() {
        return orderHistories.size();
    }


    //holding the item and the view.
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_fprice, tv_delieveryadd, tv_date;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_fprice = itemView.findViewById(R.id.tv_fprice);
            tv_delieveryadd = itemView.findViewById(R.id.tv_deliveradd);
            tv_date = itemView.findViewById(R.id.tv_date);
        }

        public void bind(final OrderHistory orderHistory, final OrderHistoryAdapter.OnItemClickListener listener){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(orderHistory);

                }
            });
        }


    }
}
