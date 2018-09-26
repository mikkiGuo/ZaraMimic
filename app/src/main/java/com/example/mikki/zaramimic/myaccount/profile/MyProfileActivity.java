package com.example.mikki.zaramimic.myaccount.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.myaccount.MyAccountActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mikki.zaramimic.data.network.NetworkHelper.sharedPreferences;

public class MyProfileActivity extends AppCompatActivity {

    @BindView(R.id.tv_infosum)
    TextView tvInfosum;
    @BindView(R.id.tv_emailtop)
    TextView tvEmailtop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        ButterKnife.bind(this);
        String email = sharedPreferences.getString("email", "");
        tvEmailtop.setText(email);
        displayProfileCard();

    }

    private void displayProfileCard() {
        String fname = sharedPreferences.getString("fname", "");
        String lname = sharedPreferences.getString("lname", "");
        String phone = sharedPreferences.getString("mobile", "");
        String address = sharedPreferences.getString("address", "mystreetname");
        tvInfosum.setText(fname + " " + lname + "\n" +address + "\n+1 "+ phone);
    }

    @OnClick({R.id.icon_back, R.id.btn_changepw, R.id.btn_changephone, R.id.card_infoholder})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.icon_back:
                Intent intent1 = new Intent(this, MyAccountActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_changepw:
                break;
            case R.id.btn_changephone:
                break;
            case R.id.card_infoholder:
                Intent intent = new Intent(this, UpdateProfileActivity.class);
                startActivity(intent);
                break;

        }
    }
}
