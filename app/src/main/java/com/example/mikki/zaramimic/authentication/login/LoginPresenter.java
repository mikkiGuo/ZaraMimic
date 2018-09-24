package com.example.mikki.zaramimic.authentication.login;

import android.content.Context;
import android.view.View;

import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;

public class LoginPresenter implements ILoginPresenter, IDataManager.OnLoginListener {

    ILoginView iLoginView;
    Context context;
    IDataManager iDataManager;
    public LoginPresenter(LoginActivity loginActivity) {
        iLoginView = loginActivity;
        context = loginActivity;
        iDataManager = new DataManager(loginActivity);
    }

    /**
     * handle all click command from login activity in this method
     * @param view
     */
    @Override
    public void onClickHandler(View view) { }

    @Override
    public void onBtnLoginClickHandler() {
        iDataManager.checkLoginValidation(this, iLoginView.getLoginData());
    }


    //should put intent in activities.
    /**
     * if username and password matched, go to category activity
     * else, show error message
     * @param result
     */

    @Override
    public void isAuthorized(boolean result) {
        iLoginView.isAuthorized(result);
    }

}
