package com.example.mikki.zaramimic.login;

import com.example.mikki.zaramimic.data.network.model.Login;

public interface ILoginView {

    public Login getLoginData();
    public void showInvalidMsg();

}
