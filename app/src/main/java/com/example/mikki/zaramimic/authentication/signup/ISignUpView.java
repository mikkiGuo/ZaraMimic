package com.example.mikki.zaramimic.authentication.signup;

import com.example.mikki.zaramimic.data.network.model.UserProfile;

public interface ISignUpView {

    UserProfile getInputProfileData();

    void showError();

}
