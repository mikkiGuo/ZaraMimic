package com.example.mikki.zaramimic.myaccount.profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.myaccount.MyAccountActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.example.mikki.zaramimic.data.network.NetworkHelper.sharedPreferences;

public class UpdateProfileActivity extends AppCompatActivity implements IUpdateProfileView {

    IUpdateProfilePresenter iUpdateProfilePresenter;

    @BindView(R.id.txt_changefn)
    EditText txtChangefn;
    @BindView(R.id.txt_changeln)
    EditText txtChangeln;
    @BindView(R.id.txt_changeemail)
    EditText txtChangeemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        ButterKnife.bind(this);

        iUpdateProfilePresenter = new UpdateProfilePresenter(this);

    }

    @OnClick({R.id.tv_cancel, R.id.tv_saveinfo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                finish();
                break;
            case R.id.tv_saveinfo:
                String fn = txtChangefn.getText().toString();
                String ln = txtChangeln.getText().toString();
                String email = txtChangeemail.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("fname", fn);
                editor.putString("lname", ln);
                editor.putString("email", email);
                editor.commit();
                Toast.makeText(this, "Profile Updated", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MyProfileActivity.class);
                startActivity(intent);
                break;
        }
    }
}
