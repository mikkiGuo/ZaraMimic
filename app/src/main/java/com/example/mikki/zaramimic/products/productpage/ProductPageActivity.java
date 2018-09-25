package com.example.mikki.zaramimic.products.productpage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.network.model.Product;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductPageActivity extends AppCompatActivity implements IProductPageView {

    IProductPagePresenter iProductPagePresenter;

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.tv_ppname)
    TextView tvPname;
    @BindView(R.id.tv_pprice)
    TextView tvPrice;

    Product p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        ButterKnife.bind(this);
        iProductPagePresenter = new ProductPagePresenter(this);
        showProductOnScreen();

    }

    private void showProductOnScreen() {
        p = getIntent().getExtras().getParcelable("product_item");
        tvPname.setText(p.getPname());
        tvPrice.setText(p.getPrize() + " USD");
        Picasso.get().load(p.getImage()).into(imageView);
    }

    @OnClick({R.id.btn_addtocart, R.id.icon_pwishlist})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.btn_addtocart:
                iProductPagePresenter.onBtnAddClickHandler(p);
                break;
            case R.id.icon_pwishlist:
                iProductPagePresenter.onWishlistClickHandler(p);

                default:break;
        }
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }
}
