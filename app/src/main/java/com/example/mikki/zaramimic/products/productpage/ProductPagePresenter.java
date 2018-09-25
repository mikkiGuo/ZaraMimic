package com.example.mikki.zaramimic.products.productpage;

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
        iDataManager.addProductToShoppingCartDB(this, p);
    }

    @Override
    public void onWishlistClickHandler(Product p) {
        iDataManager.addProductToWishListDB(this, p);
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
