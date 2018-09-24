package com.example.mikki.zaramimic.authentication.forgotpw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.authentication.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPWActivity extends AppCompatActivity implements IForgotPWView {

    @BindView(R.id.tv_no_email)
    TextView tvNoEmail;

    IForgotPWPresenter iForgotPWPresenter;
    @BindView(R.id.txt_email_in_forgot)
    EditText txtEmailInForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);

        iForgotPWPresenter = new ForgotPWPresenter(this);

    }

    @OnClick(R.id.btn_toresetpw)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.btn_toresetpw:
                iForgotPWPresenter.onClickHandler(txtEmailInForgot.getText().toString());
        }

    }

    @Override
    public void showStatus(boolean result) {
        if(result){
            Toast.makeText(this, "Reset Password Email Sent", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else{
            tvNoEmail.setText("email not existed");
        }
    }
}
