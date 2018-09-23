package com.example.mikki.zaramimic.data.network.model;

public class Login {
    String mobileNum, password;

    public Login(String username, String password) {
        this.mobileNum = username;
        this.password = password;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
