package com.example.mikki.zaramimic.authentication.signup;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.UserProfile;
import com.example.mikki.zaramimic.authentication.login.LoginActivity;

public class SignUpPresenter implements ISignUpPresenter, IDataManager.OnSignUpListener {

    ISignUpView iSignUpView;
    IDataManager iDataManager;
    Context context;

    public SignUpPresenter(SignUpActivity signUpActivity) {
        iSignUpView = signUpActivity;
        iDataManager = new DataManager(signUpActivity);
        context = signUpActivity;
    }

    @Override
    public void isSignUpSuccessful(boolean result) {
        if(result){
            Intent intent = new Intent(context, LoginActivity.class);
            context.startActivity(intent);
        }else{
            iSignUpView.showError();
        }
    }

    @Override
    public void onClickHandler(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                UserProfile profile = iSignUpView.getInputProfileData();
                iDataManager.userRegistration(this, profile);
                break;

            case R.id.btn_cancel:
                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
                break;

                default: break;
        }
    }
}
