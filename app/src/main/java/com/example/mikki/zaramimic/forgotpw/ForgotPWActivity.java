package com.example.mikki.zaramimic.forgotpw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mikki.zaramimic.R;

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
        iForgotPWPresenter.onClickHandler(view);
    }

    @Override
    public void showStatus(String s) {
        tvNoEmail.setText(s);
    }

    @Override
    public String getEmail() {
        return txtEmailInForgot.getText().toString();
    }
}
