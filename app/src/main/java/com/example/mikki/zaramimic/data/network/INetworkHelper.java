package com.example.mikki.zaramimic.data.network;

import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Category;
import com.example.mikki.zaramimic.data.network.model.Login;
import com.example.mikki.zaramimic.data.network.model.UserProfile;

import java.util.List;


public interface INetworkHelper {

    public void userRegistration(IDataManager.OnSignUpListener listener, UserProfile profile);

    public void checkLoginValidation(IDataManager.OnLoginListener listener, Login login);

    public void sendEmailToServerForReset(IDataManager.OnForgotPWListener listener, String email);

    public void getCategoriesFromServer(IDataManager.OnCategoriesListener listener);

    public void getSubCategoriesFromServer(IDataManager.OnSubCategoriesListener listener);

    public void getProductListFromServer(IDataManager.OnProductListListener listener);

}
