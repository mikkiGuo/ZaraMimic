package com.example.mikki.zaramimic.authentication.login;

import com.example.mikki.zaramimic.data.network.model.Login;

public interface ILoginView {

    Login getLoginData();
    void showInvalidMsg();
    void isAuthorized(boolean result);

}
