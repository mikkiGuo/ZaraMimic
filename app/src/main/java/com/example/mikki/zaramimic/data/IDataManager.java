package com.example.mikki.zaramimic.data;

import com.example.mikki.zaramimic.data.database.IDbHelper;
import com.example.mikki.zaramimic.data.network.INetworkHelper;
import com.example.mikki.zaramimic.data.network.model.Category;
import com.example.mikki.zaramimic.data.network.model.OrderHistory;
import com.example.mikki.zaramimic.data.network.model.Product;
import com.example.mikki.zaramimic.data.network.model.SubCategory;

import java.util.List;


public interface IDataManager extends IDbHelper, INetworkHelper {


    interface OnSignUpListener{
        void isSignUpSuccessful(boolean result);
    }

    interface OnLoginListener{

        void isAuthorized(boolean result);

    }

    interface OnForgotPWListener{
        void isEmailExisted(boolean result);
    }

    interface OnResetPWListener{
        void isResetSuccessful(boolean result);
    }

    interface OnCategoriesListener{

        void bindCategoriesToView(List<Category> categoryList);

    }

    interface OnSubCategoriesListener{
        void bindSubCategoriesToView(List<SubCategory> subCategories);
    }

    interface OnProductListListener{
        void bindProductsToView(List<Product> productList);
    }

    interface OnOrderListener {

        //void passItemInfo(String pid, String pname, String pprice, String porder_quan);
        void passItemsFromCartToOrder(List<Product> cart);

        void isOrderPlacedSucessful(boolean result);

    }

    interface OnOrderHistoryListener{
        void bindOrderHistoryToView(List<OrderHistory> orderHistoryList);
    }

    /*---------------------------------------------------------------------------------------------
                                LOCAL DATABASE LISTENERS
     ---------------------------------------------------------------------------------------------*/

    interface OnProductListener{
        void isAddedToDB(boolean result);
    }

    interface OnShoppingCartListener{
        void bindProductListFromDBToView(List<Product> productList);
        void isProductDeleted(boolean result);
    }

    interface OnWishListListener{
        void bindProductsFromDBtoView(List<Product> productList);
    }

    interface OnProfileUpdateListener{
        void isUpateSuccessful(boolean result);
    }
    


}
