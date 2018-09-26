package com.example.mikki.zaramimic.myaccount.profile;

import com.example.mikki.zaramimic.data.IDataManager;

public class UpdateProfilePresenter implements IUpdateProfilePresenter {

    IUpdateProfileView iUpdateProfileView;
    IDataManager iDataManager;

    public UpdateProfilePresenter(UpdateProfileActivity updateProfileActivity) {

    }


    @Override
    public void sendUpdatedProfileToServer(String fname, String lname, String email) {

    }
}
