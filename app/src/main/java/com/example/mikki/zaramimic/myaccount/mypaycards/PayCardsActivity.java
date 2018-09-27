package com.example.mikki.zaramimic.myaccount.mypaycards;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.example.mikki.zaramimic.R;
import com.simplify.android.sdk.CardEditor;
import com.simplify.android.sdk.CardToken;
import com.simplify.android.sdk.Simplify;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PayCardsActivity extends AppCompatActivity {

    private static final String TAG = "hello";
    private Simplify simplify;

    @BindView(R.id.btn_payment)
    Button btnPayment;
    @BindView(R.id.card_editor)
    CardEditor cardEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_cards);
        ButterKnife.bind(this);


        simplify = new Simplify();
        simplify.setApiKey("sbpb_Nzg5M2RmNTUtYjYxYS00Yjg3LWJjOWItODFiYjI1NzdlMWYw");


        cardEditor.addOnStateChangedListener(new CardEditor.OnStateChangedListener() {
            @Override
            public void onStateChange(CardEditor cardEditor) {
                btnPayment.setEnabled(cardEditor.isValid());
            }
        });
    }

    @OnClick(R.id.btn_payment)
    public void onViewClicked() {
        simplify.createCardToken(cardEditor.getCard(), new CardToken.Callback() {
            @Override
            public void onSuccess(CardToken cardToken) {
                Log.d(TAG, "onSuccess: " + cardToken.getCard().toString());
            }

            @Override
            public void onError(Throwable throwable) {
                Log.d(TAG, "onError: " + throwable.getMessage());
            }
        });

    }

}
