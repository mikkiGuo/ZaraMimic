package com.example.mikki.zaramimic.authentication.forgotpw;

import android.content.Context;

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
    public void onClickHandler(String userEmail) {
        iDataManager.sendEmailToServerForReset(this, userEmail);

    }

    @Override
    public void isEmailExisted(boolean result) {
        iForgotPWView.showStatus(result);
    }




}
