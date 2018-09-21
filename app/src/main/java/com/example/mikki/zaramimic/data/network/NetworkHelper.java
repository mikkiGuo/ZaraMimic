package com.example.mikki.zaramimic.data.network;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.network.model.AppController;
import com.example.mikki.zaramimic.data.network.model.Category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class NetworkHelper implements INetworkHelper {
    List<Category> categoryList;
    String urlCategories = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_category.php?api_key=54f7c2bdda75d7c21a1ae2b427e74563&user_id=1387";

    private static final String TAG = "hello";
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

    /**
     * read categories from server using JsonObject
     */
    private void readCategoriesFromServer(final IDataManager.OnCategoriesListener listener) {
        Log.d(TAG, "readCategoriesFromServer: ");
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                urlCategories, null, new Response.Listener<JSONObject>() {
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


                } catch (JSONException e) {
                    Log.d(TAG, "onErrors: ");
                    e.printStackTrace();

                }
                listener.bindCategoriesToView(categoryList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);

    }

    //below methods is to test the mvp framwork connections.
    @Override
    public void testDb(IDataManager.OnCategoriesListener listener) {
        listener.connectToSever();
    }


}
