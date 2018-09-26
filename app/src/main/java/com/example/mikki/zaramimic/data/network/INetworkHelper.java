package com.example.mikki.zaramimic.data.network;

import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Login;
import com.example.mikki.zaramimic.data.network.model.UserProfile;


public interface INetworkHelper {

    void userRegistration(IDataManager.OnSignUpListener listener, UserProfile profile);

    void checkLoginValidation(IDataManager.OnLoginListener listener, Login login);

    void sendEmailToServerForReset(IDataManager.OnForgotPWListener listener, String email);


    void getCategoriesFromServer(IDataManager.OnCategoriesListener listener);

    void getSubCategoriesFromServer(IDataManager.OnSubCategoriesListener listener);

    void getProductListFromServer(IDataManager.OnProductListListener listener);

}
