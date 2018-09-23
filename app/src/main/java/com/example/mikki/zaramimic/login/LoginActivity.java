package com.example.mikki.zaramimic.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.Login;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    ILoginPresenter iLoginPresenter;

    @BindView(R.id.txt_username)
    EditText txtUsername;
    @BindView(R.id.txt_password)
    EditText txtPassword;
    @BindView(R.id.tv_showmsg)
    TextView tvShowmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        iLoginPresenter = new LoginPresenter(this);

    }

    @OnClick({R.id.btn_login, R.id.tv_to_resetpw, R.id.btn_tosignup})
    public void onViewClicked(View view) {
        iLoginPresenter.onClickHandler(view);
    }


    @Override
    public Login getLoginData() {
        String un = txtUsername.getText().toString();
        String pw = txtPassword.getText().toString();
        Login login = new Login(un, pw);

        return login;
    }

    @Override
    public void showInvalidMsg() {
        tvShowmsg.setText("username and password not matched, please try again...");
    }
}
