package com.example.mikki.zaramimic.authentication.resetpw;

import android.content.Context;

import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;

public class ResetPWPresenter implements IResetPWPresenter, IDataManager.OnResetPWListener {

    IResetPWView iResetPWView;
    Context context;
    IDataManager iDataManager;

    public ResetPWPresenter(ResetPWActivity resetPWActivity) {
        iResetPWView = resetPWActivity;
        context = resetPWActivity;
        iDataManager = new DataManager(resetPWActivity);
    }

    @Override
    public void isResetSuccessful(boolean result) {

    }
}
