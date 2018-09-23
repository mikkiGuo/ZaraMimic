package com.example.mikki.zaramimic.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.category.CategoryActivity;
import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Login;
import com.example.mikki.zaramimic.signup.SignUpActivity;

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
    public void onClickHandler(View view) {

        switch (view.getId()) {
            case R.id.btn_login:
                iDataManager.checkLoginValidation(this, iLoginView.getLoginData());
                break;

            case R.id.tv_to_resetpw:

                break;
            case R.id.btn_tosignup:
                Intent intent = new Intent(context, SignUpActivity.class);
                context.startActivity(intent);
                break;

                default:
                    break;
        }

    }


    /**
     * if username and password matched, go to category activity
     * else, show error message
     * @param result
     */
    @Override
    public void isAuthorized(boolean result) {

        if(result){
            Intent intent = new Intent(context, CategoryActivity.class);
            context.startActivity(intent);
        }else{
            iLoginView.showInvalidMsg();
        }

    }

}
