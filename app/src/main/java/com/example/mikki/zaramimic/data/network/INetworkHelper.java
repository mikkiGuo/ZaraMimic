package com.example.mikki.zaramimic.data.network;

import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Login;
import com.example.mikki.zaramimic.data.network.model.Order;
import com.example.mikki.zaramimic.data.network.model.UserProfile;
import com.example.mikki.zaramimic.orders.order.OrderPresenter;

import java.util.List;


public interface INetworkHelper {

    void userRegistration(IDataManager.OnSignUpListener listener, UserProfile profile);

    void checkLoginValidation(IDataManager.OnLoginListener listener, Login login);

    void sendEmailToServerForReset(IDataManager.OnForgotPWListener listener, String email);


    void getCategoriesFromServer(IDataManager.OnCategoriesListener listener);

    void getSubCategoriesFromServer(IDataManager.OnSubCategoriesListener listener);

    void getProductListFromServer(IDataManager.OnProductListListener listener);

    void checkout(IDataManager.OnOrderListener listener, List<Order> orderItemList);


    //void checkout(IDataManager.OnCheckoutListener onCheckoutListener, String pid, String pname, String porder_quan, String pprice, String userID, String fname, String billingadd, String deliveryadd, String phone, String email, String apiKey);
}
