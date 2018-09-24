package com.example.mikki.zaramimic.authentication.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.products.category.CategoryActivity;
import com.example.mikki.zaramimic.data.network.model.Login;
import com.example.mikki.zaramimic.authentication.forgotpw.ForgotPWActivity;
import com.example.mikki.zaramimic.authentication.signup.SignUpActivity;

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
        switch (view.getId()) {
            case R.id.btn_login:
                iLoginPresenter.onBtnLoginClickHandler();
                break;

            case R.id.tv_to_resetpw:
                Intent intent = new Intent(this, ForgotPWActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_tosignup:
                Intent intent1 = new Intent(this, SignUpActivity.class);
                startActivity(intent1);
                break;

            default:
                break;
        }
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

    @Override
    public void isAuthorized(boolean result) {
        if(result){
            Intent intent = new Intent(this, CategoryActivity.class);
            startActivity(intent);
        }else{

            tvShowmsg.setText("username and password not matched, please try again...");
        }
    }
}
