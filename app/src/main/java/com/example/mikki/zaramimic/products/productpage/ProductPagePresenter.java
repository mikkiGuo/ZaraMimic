package com.example.mikki.zaramimic.products.productpage;

import android.content.Context;
import android.view.View;

import com.example.mikki.zaramimic.R;
import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Product;

public class ProductPagePresenter implements IProductPagePresenter, IDataManager.OnProductListener {

    IProductPageView iProductPageView;
    IDataManager iDataManager;


    public ProductPagePresenter(ProductPageActivity productPageActivity) {

        iProductPageView = productPageActivity;
        iDataManager = new DataManager(productPageActivity);
    }


    @Override
    public void onBtnAddClickHandler(Product p) {
        iDataManager.addProductToDB(this, p);
    }


    @Override
    public void isAddedToDB(boolean result) {
        if(result){
            iProductPageView.showToast("item added to cart");
        }else{
            iProductPageView.showToast("item failed to add to cart");
        }
    }
}
