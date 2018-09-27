package com.example.mikki.zaramimic.orders.order;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.Order;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mikki.zaramimic.data.network.NetworkHelper.sharedPreferences;

public class OrderActivity extends AppCompatActivity implements IOrderView {


    private static final String TAG = "showconnections";
    IOrderPresenter iOrderPresenter;

    @BindView(R.id.txt_billingadd)
    EditText txtBillingadd;
    @BindView(R.id.txt_deliveryadd)
    EditText txtDeliveryadd;
    @BindView(R.id.tv_placestatus)
    TextView tvPlacestatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);

        iOrderPresenter = new OrderPresenter(this);




    }
    
    @Override
    public void groupInfo(List<Order> orderItemList) {
        Log.d(TAG, "groupInfo executed: ");
        String apiKey = sharedPreferences.getString("api_key", "");
        String userID = sharedPreferences.getString("user_id", "");
        String fname = sharedPreferences.getString("fname", "");
        String lname = sharedPreferences.getString("lname", "");
        String phone = sharedPreferences.getString("mobile", "");
        //String address = sharedPreferences.getString("address", "mystreetname");
        String billingadd = sharedPreferences.getString("billingadd", "not found");
        String deliveryadd = sharedPreferences.getString("deliveryadd", "not found");
        String email = sharedPreferences.getString("email", "hello.com");

        for (int i = 0; i < orderItemList.size(); i++) {
            orderItemList.get(i).setApi_key(apiKey);
            orderItemList.get(i).setUser_id(userID);
            orderItemList.get(i).setUser_name(fname + " " + lname);
            orderItemList.get(i).setMobile(phone);
            orderItemList.get(i).setBillingadd(billingadd);
            orderItemList.get(i).setDeliveryadd(deliveryadd);
            orderItemList.get(i).setEmail(email);
        }

        iOrderPresenter.checkout(orderItemList);

    }

    @Override
    public void displayStatus(String s) {
        Log.d(TAG, "displayStatus: ");
        tvPlacestatus.setText(s);
    }

    @OnClick(R.id.btn_pay)
    public void onViewClicked() {
        Log.d(TAG, "onViewClicked: ");
        String bill = txtBillingadd.getText().toString();
        String delivery = txtDeliveryadd.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("billingadd", bill);
        editor.putString("deliveryadd", delivery);
        editor.commit();
        iOrderPresenter.getShoppingCartInfo();
    }
}
