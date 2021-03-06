package com.example.mikki.zaramimic.products.productlist;

import com.example.mikki.zaramimic.data.DataManager;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.Product;

import java.util.List;

public class ProductListPresenter implements IProductListPresenter, IDataManager.OnProductListListener{

    IProductListView iProductListView;
    IDataManager iDataManager;

    public ProductListPresenter(ProductListActivity productListActivity) {

        iProductListView = productListActivity;
        iDataManager = new DataManager(productListActivity);
    }


    @Override
    public void onActivityCreated() {
        iDataManager.getProductListFromServer(this);
    }


    @Override
    public void bindProductsToView(List<Product> productList) {
        iProductListView.showProductList(productList);
    }

}
