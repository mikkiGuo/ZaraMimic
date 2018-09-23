package com.example.mikki.zaramimic.forgotpw;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;

public class ForgotPWPresenter implements IForgotPWPresenter, IDataManager.OnForgotPWListener {

    IForgotPWView iForgotPWView;
    Context context;
    IDataManager iDataManager;

    public ForgotPWPresenter(ForgotPWActivity forgotPWActivity) {
        iForgotPWView = forgotPWActivity;
        iDataManager = new DataManager(forgotPWActivity);
        context = forgotPWActivity;
    }

    @Override
    public void onClickHandler(View view) {
        String userEmail = iForgotPWView.getEmail();
        iDataManager.checkEmailFromServer(this, userEmail);

    }

    @Override
    public void isEmailExisted(boolean result) {

        if(result){
            iForgotPWView.showStatus("reset password email sent");
        }else{
            iForgotPWView.showStatus("email not existed");
        }

    }




}
