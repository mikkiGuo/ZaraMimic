package com.example.mikki.zaramimic.orders.order;

import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Order;
import com.example.mikki.zaramimic.data.network.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderPresenter implements IOrderPresenter, IDataManager.OnOrderListener {
    IOrderView iOrderView;
    IDataManager iDataManager;
    public OrderPresenter(OrderActivity orderActivity) {
        iDataManager = new DataManager(orderActivity);
        iOrderView = orderActivity;
    }


    @Override
    public void getShoppingCartInfo() {
        iDataManager.getProductsFromShoppingCartDB(this);
    }

    /*@Override
    public void checkout(String pid, String pname, String porder_quan, String pprice, String userID, String fname, String billingadd, String deliveryadd, String phone, String email, String apiKey) {

    }*/

    @Override
    public void checkout(List<Order> orderItemList) {
        iDataManager.checkout(this, orderItemList);
    }

    @Override
    public void passItemsFromCartToOrder(List<Product> cart) {

        List<Order> orderItemList = new ArrayList<>();

        for(int i = 0; i< cart.size(); i++){
            String item_id = cart.get(i).getId();
            String item_name = cart.get(i).getPname();
            String item_quantity = String.valueOf(cart.get(i).getOrder_quantity());
            String item_price = cart.get(i).getPrize();

            Order item = new Order(item_id, item_name, item_quantity);
            item.setFinal_priceS(item_price);

            orderItemList.add(item);
        }

        iOrderView.groupInfo(orderItemList);

    }

    @Override
    public void isOrderPlacedSucessful(boolean result) {
        if(result){
            iOrderView.displayStatus("order placed\n");
        }else{
            iOrderView.displayStatus("fail to place order\n");
        }

    }
}
