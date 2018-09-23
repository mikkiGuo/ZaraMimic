package com.example.mikki.zaramimic.signup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.UserProfile;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity implements ISignUpView {

    ISignUpPresenter iSignUpPresenter;
    @BindView(R.id.txt_email)
    EditText txtEmail;
    @BindView(R.id.txt_createpw)
    EditText txtCreatepw;
    @BindView(R.id.txt_fname)
    EditText txtFname;
    @BindView(R.id.txt_lname)
    EditText txtLname;
    @BindView(R.id.txt_address)
    EditText txtAddress;
    @BindView(R.id.txt_phone)
    EditText txtPhone;
    @BindView(R.id.tv_showerror)
    TextView tvShowerror;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        iSignUpPresenter = new SignUpPresenter(this);
    }

    @OnClick({R.id.btn_save, R.id.btn_cancel})
    public void onViewClicked(View view) {
        iSignUpPresenter.onClickHandler(view);
    }

    @Override
    public UserProfile getInputProfileData() {

        String fn = txtFname.getText().toString();
        String ln = txtLname.getText().toString();
        String address = txtAddress.getText().toString();
        String email = txtEmail.getText().toString();
        String mobile = txtPhone.getText().toString();
        String password = txtCreatepw.getText().toString();

        UserProfile userProfile = new UserProfile(fn, ln, address, email, mobile, password);

        return userProfile;
    }

    @Override
    public void showError() {
        tvShowerror.setText("sign up failed, please fill all fields.");
    }


}
