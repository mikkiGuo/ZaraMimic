package com.example.mikki.zaramimic.authentication.login;

import com.example.mikki.zaramimic.data.network.model.Login;

public interface ILoginView {

    public Login getLoginData();
    public void showInvalidMsg();
    public void isAuthorized(boolean result);

}
