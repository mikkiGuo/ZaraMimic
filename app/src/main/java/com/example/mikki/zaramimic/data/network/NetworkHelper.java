package com.example.mikki.zaramimic.data.network;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.AppController;
import com.example.mikki.zaramimic.data.network.model.Category;
import com.example.mikki.zaramimic.data.network.model.Product;
import com.example.mikki.zaramimic.data.network.model.SubCategory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class NetworkHelper implements INetworkHelper {
    List<Category> categoryList;
    List<SubCategory> subCategoryList;
    List<Product> productList;

    String url_categories = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_category.php?api_key=8d1297ce46af115ad60d30facf97d149&user_id=1395";
    String url_subcategories = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_sub_category.php?Id=107&api_key=8d1297ce46af115ad60d30facf97d149&user_id=1395";
    String url_productlist = "http://rjtmobile.com/ansari/shopingcart/androidapp/product_details.php?cid=107&scid=205&api_key=8d1297ce46af115ad60d30facf97d149&user_id=1395";



    private static final String TAG = "hello";



    /*------------------------------------------------------------------------------------
            Override methods from interfaces.
     -----------------------------------------------------------------------------------*/
    /**
     * get categories data from server
     * perform the volley n/w call
     * parse the json
     * return a list of category objects by passing the object back to presenter.
     * @param listener
     */
    @Override
    public void getCategoriesFromServer(IDataManager.OnCategoriesListener listener) {
        categoryList = new ArrayList<Category>();
        readCategoriesFromServer(listener);

    }

    @Override
    public void getSubCategoriesFromServer(IDataManager.OnSubCategoriesListener listener) {

        subCategoryList = new ArrayList<SubCategory>();
        readSubCategoriesFromServer(listener);

    }

    @Override
    public void getProductListFromServer(IDataManager.OnProductListListener listener) {

        productList = new ArrayList<Product>();
        readProductListFromServer(listener);
    }



    /*-----------------------------------------------------------------------------------
            private methods to read different data from server
     -----------------------------------------------------------------------------------*/
    /**
     * read categories from server using JsonObject Request
     */
    private void readCategoriesFromServer(final IDataManager.OnCategoriesListener listener) {
        Log.d(TAG, "readCategoriesFromServer: ");
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url_categories, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse: ");
                // Parsing json object response
                // response will be a json object
                try {
                    JSONArray jsonArray = response.getJSONArray("category");

                    for(int i = 0; i<jsonArray.length(); i++){
                        JSONObject category = jsonArray.getJSONObject(i);
                        String cid = category.getString("cid");
                        String cname = category.getString("cname");
                        String cdiscription = category.getString("cdiscription");
                        String cimagerl = category.getString("cimagerl");
                        Log.d("data", "onResponse: " + cname);

                        //Toast.makeText(MainActivity.this, "" + cname, Toast.LENGTH_SHORT).show();
                        Category c = new Category(cid, cname, cdiscription, cimagerl);
                        categoryList.add(c);

                    }
                    listener.bindCategoriesToView(categoryList);

                } catch (JSONException e) {
                    Log.d(TAG, "onErrors: ");
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);

    }

    /**
     * read sub_categories from server using JsonObject Request
     * @param listener
     */
    private void readSubCategoriesFromServer(final IDataManager.OnSubCategoriesListener listener){
        Log.d(TAG, "readSubCategoriesFromServer: ");

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url_subcategories, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse: ");
                // Parsing json object response
                // response will be a json object
                try {
                    JSONArray jsonArray = response.getJSONArray("subcategory");

                    for(int i = 0; i<jsonArray.length(); i++){
                        JSONObject subcategory = jsonArray.getJSONObject(i);
                        String scid = subcategory.getString("scid");
                        String scname = subcategory.getString("scname");
                        String scdiscription = subcategory.getString("scdiscription");
                        String scimageurl = subcategory.getString("scimageurl");
                        Log.d("data", "onResponse: " + scname);

                        SubCategory c
                                = new SubCategory(scid, scname, scdiscription, scimageurl);
                        subCategoryList.add(c);

                    }
                    listener.bindSubCategoriesToView(subCategoryList);

                } catch (JSONException e) {
                    Log.d(TAG, "onErrors: ");
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

    /**
     * read product list from server using JsonObject Request
     * @param listener
     */
    private void readProductListFromServer(final IDataManager.OnProductListListener listener) {
        Log.d(TAG, "readSubCategoriesFromServer: ");

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url_productlist, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse: ");
                // Parsing json object response
                // response will be a json object
                try {
                    JSONArray jsonArray = response.getJSONArray("products");

                    for(int i = 0; i<jsonArray.length(); i++){

                        JSONObject product = jsonArray.getJSONObject(i);

                        String id = product.getString("id");
                        String pname = product.getString("pname");
                        String quantity = product.getString("quantity");
                        String prize = product.getString("prize");
                        String discription = product.getString("discription");
                        String image = product.getString("image");

                        Product p
                                = new Product(id, pname, quantity, prize, discription, image);
                        productList.add(p);

                    }
                    listener.bindProductsToView(productList);

                } catch (JSONException e) {
                    Log.d(TAG, "onErrors: ");
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);



    }


    //below methods is to test the mvp skelton connections.
    @Override
    public void testDb(IDataManager.OnCategoriesListener listener) {
        listener.connectToSever();
    }

}

