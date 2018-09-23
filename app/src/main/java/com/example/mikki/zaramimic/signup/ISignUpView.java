package com.example.mikki.zaramimic.signup;

import com.example.mikki.zaramimic.data.network.model.UserProfile;

public interface ISignUpView {

    public UserProfile getInputProfileData();

    public void showError();

}
