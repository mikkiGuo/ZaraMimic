package com.example.mikki.zaramimic.myaccount.profile;

import com.example.mikki.zaramimic.data.IDataManager;

public interface IUpdateProfilePresenter {

    public void sendUpdatedProfileToServer(String fname, String lname, String email);
}
