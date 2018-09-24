package com.example.mikki.zaramimic.data;

import com.example.mikki.zaramimic.data.database.IDbHelper;
import com.example.mikki.zaramimic.data.network.INetworkHelper;
import com.example.mikki.zaramimic.data.network.model.Category;
import com.example.mikki.zaramimic.data.network.model.Product;
import com.example.mikki.zaramimic.data.network.model.SubCategory;

import java.util.List;


public interface IDataManager extends IDbHelper, INetworkHelper {

    interface OnResponseListener{ /// switch board
        public void connectToDb();
    }

    interface OnProductListener{
        void isAddedToDB(boolean result);
    }

    interface OnSignUpListener{
        public void isSignUpSuccessful(boolean result);
    }

    interface OnLoginListener{

        public void isAuthorized(boolean result);

    }

    interface OnForgotPWListener{
        public void isEmailExisted(boolean result);
    }

    interface OnResetPWListener{
        public void isResetSuccessful(boolean result);
    }

    interface OnCategoriesListener{

        public void bindCategoriesToView(List<Category> categoryList);

    }

    interface OnSubCategoriesListener{
        public void bindSubCategoriesToView(List<SubCategory> subCategories);
    }

    interface OnProductListListener{
        public void bindProductsToView(List<Product> productList);
    }


}
