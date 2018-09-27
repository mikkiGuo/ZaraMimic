package com.example.mikki.zaramimic.data.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.mikki.zaramimic.dagger.CategoryModule;
import com.example.mikki.zaramimic.dagger.DaggerMyComponent;
import com.example.mikki.zaramimic.dagger.MyComponent;
import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.AppController;
import com.example.mikki.zaramimic.data.network.model.Category;
import com.example.mikki.zaramimic.data.network.model.Login;
import com.example.mikki.zaramimic.data.network.model.Order;
import com.example.mikki.zaramimic.data.network.model.Product;
import com.example.mikki.zaramimic.data.network.model.SubCategory;
import com.example.mikki.zaramimic.data.network.model.UserProfile;
import com.example.mikki.zaramimic.orders.order.OrderPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class NetworkHelper implements INetworkHelper {

    List<Category> categoryList;
    List<SubCategory> subCategoryList;
    List<Product> productList;


    private static final String TAG = "hello";
    URLKeeper urlKeeper = URLKeeper.getInstance();

    public static SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;


    //dagger class declaration
    @Inject
    Category c;
    //@Inject
    //CategoryModule categoryModule;
    MyComponent myComponent;


    public NetworkHelper(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("apifile", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    /*------------------------------------------------------------------------------------
            Override methods from interfaces.
     -----------------------------------------------------------------------------------*/

    @Override
    public void checkLoginValidation(IDataManager.OnLoginListener listener, Login login) {
        String url_login = "http://rjtmobile.com/aamir/e-commerce/android-app/shop_login.php?"
                + "mobile=" + login.getMobileNum()
                + "&" + "password=" + login.getPassword();
        authenticateIDFromServer(listener, url_login);
    }

    /**
     * perform send email to server,
     * if server response successful, return true
     * if email doesn't exist, return false.
     * @param listener
     * @param email
     */
    @Override
    public void sendEmailToServerForReset(IDataManager.OnForgotPWListener listener, String email) {
        listener.isEmailExisted(true);
    }


    @Override
    public void userRegistration(IDataManager.OnSignUpListener listener, UserProfile profile) {
        String url_signup = "http://rjtmobile.com/aamir/e-commerce/android-app/shop_reg.php?"
                +"fname=" + profile.getFname()
                + "&" + "lname=" + profile.getLname()
                + "&" + "address=" + profile.getAddress()
                + "&" + "email=" + profile.getEmail()
                + "&" + "mobile=" + profile.getMobile()
                + "&" + "password=" + profile.getPassword();
        editor.putString("address", profile.getAddress());
        registerUserToServer(listener, url_signup);

    }

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
        String apiKey = sharedPreferences.getString("api_key", "");
        String userID = sharedPreferences.getString("user_id", "");

        String url_category = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_category.php?"
                + "api_key=" + apiKey
                + "&" + "user_id=" + userID;


        readCategoriesFromServer(listener, url_category);

    }

    @Override
    public void getSubCategoriesFromServer(IDataManager.OnSubCategoriesListener listener) {
        String apiKey = sharedPreferences.getString("api_key", "");
        String userID = sharedPreferences.getString("user_id", "");
        String cid = sharedPreferences.getString("cid", "107");
        String url_subcategory = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_sub_category.php?"
                + "Id=" + cid
                + "&api_key=" + apiKey
                + "&user_id=" + userID;
        subCategoryList = new ArrayList<SubCategory>();
        readSubCategoriesFromServer(listener, url_subcategory);

    }

    @Override
    public void getProductListFromServer(IDataManager.OnProductListListener listener) {
        String cid = sharedPreferences.getString("cid", "107");
        String scid = sharedPreferences.getString("scid", "205");
        String apiKey = sharedPreferences.getString("api_key", "");
        String userID = sharedPreferences.getString("user_id", "");

        String url_productlist = "http://rjtmobile.com/ansari/shopingcart/androidapp/product_details.php?" +
                "cid=" + cid + "&scid=" + scid + "&api_key=" + apiKey + "&user_id=" +userID;

        productList = new ArrayList<Product>();

        readProductListFromServer(listener, url_productlist);
    }

    @Override
    public void checkout(IDataManager.OnOrderListener listener, List<Order> orderItemList) {

        for(int i = 0; i< orderItemList.size(); i++) {
            String item_id = orderItemList.get(i).getItem_id();
            String item_name = orderItemList.get(i).getUser_name();
            String item_quantity = orderItemList.get(i).getItem_quantity();
            String final_price = orderItemList.get(i).getFinal_price();
            String api_key = orderItemList.get(i).getApi_key();
            String user_id = orderItemList.get(i).getUser_id();
            String user_name = orderItemList.get(i).getUser_name();
            String billadd = orderItemList.get(i).getBillingadd();
            String deliveryadd = orderItemList.get(i).getDeliveryadd();
            String mobile = orderItemList.get(i).getMobile();
            String email = orderItemList.get(i).getEmail();

            String order_url = urlKeeper.generateURLOrder(item_id, item_name, item_quantity,
                    final_price, api_key, user_id, user_name, billadd, deliveryadd, mobile, email);

            addOrderToServer(listener, order_url);

        }

    }



    /*@Override
    public void checkout(IDataManager.OnCheckoutListener onCheckoutListener, String pid,
                         String pname, String porder_quan, String pprice, String userID,
                         String fname, String billingadd, String deliveryadd, String phone,
                         String email, String apiKey) {
        String URL = "http://rjtmobile.com/aamir/e-commerce/android-app/orders.php?"
                +"&item_id=" + pid +
                "&item_names="+pname+
                "&item_quantity=" + porder_quan +
                "&final_price=" + pprice +
                "&&api_key=" + apiKey +
                "&user_id=" + userID +
                "&user_name=" + fname +
                "&billingadd=" + billingadd +
                "&deliveryadd=" + deliveryadd +
                "&mobile=" + phone +
                "&email=" + email;

        //JsonObjectRequest jsonObjectRequest
    }*/


    /*-----------------------------------------------------------------------------------
            private methods to read different data from server
     -----------------------------------------------------------------------------------*/

    /**
     * authenticate user,
     * if authenticated, store user information and get api key
     * if not validated, return false and notify user
     */
    private void authenticateIDFromServer(final IDataManager.OnLoginListener listener, final String url_login) {
        Log.d(TAG, "readLoginFromServer: ");
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url_login, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, "onResponseLogin: " + url_login);
                Log.d(TAG, "onResponse: \n" + response.toString());
                try {
                    JSONObject userdata = response.getJSONObject(0);
                    String userID = userdata.getString("id");
                    String apiKey = userdata.getString("appapikey ");
                    String email = userdata.getString("email");
                    String mobile = userdata.getString("mobile");
                    String fname = userdata.getString("firstname");
                    String lname = userdata.getString("lastname");

                    Log.d(TAG, "appapikey :\n" + apiKey);

                    editor.putString("api_key", apiKey);
                    editor.putString("user_id", userID);
                    editor.putString("fname", fname);
                    editor.putString("lname", lname);
                    editor.putString("email", email);
                    editor.putString("mobile", mobile);
                    editor.commit();

                    listener.isAuthorized(true);

                } catch (JSONException e) {
                    Log.d(TAG, "onErrorsLogin: " + e.toString());
                    e.printStackTrace();
                    listener.isAuthorized(false);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponseLogin: ");
                listener.isAuthorized(false);
            }
        });


        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }

    /**
     * register user to server,
     * return status of registration to signup presenter
     * @param listener
     */
    private void registerUserToServer(final IDataManager.OnSignUpListener listener, String url_signup) {
        Log.d(TAG, "registerUserToServer: ");
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url_signup, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponseSignup: " + response.toString());

                if(response.toString().equals("successfully registered") ){

                    Log.d(TAG, "" + response.toString());
                    listener.isSignUpSuccessful(true);
                }else{
                    Log.d(TAG, "" + response.toString());
                    listener.isSignUpSuccessful(false);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponseSignup: ");

            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(stringRequest);

    }

    /**
     * read categories from server using JsonObject Request
     */
    private void readCategoriesFromServer(final IDataManager.OnCategoriesListener listener, String url_categories) {
        Log.d(TAG, "readCategoriesFromServer: ");
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url_categories, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponseCategory: ");
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
                        myComponent = DaggerMyComponent.builder()
                                .categoryModule(new CategoryModule(cid, cname, cdiscription, cimagerl))
                                .build();

                        myComponent.inject(NetworkHelper.this);

                        /*c.setCid(cid);
                        c.setCname(cname);
                        c.setCdiscription(cdiscription);
                        c.setCimagerl(cimagerl);*/

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
                Log.d(TAG, "onErrorResponse: ");
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);

    }

    /**
     * read sub_categories from server using JsonObject Request
     * @param listener
     */
    private void readSubCategoriesFromServer(final IDataManager.OnSubCategoriesListener listener, String url_subcategories){
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
                    Log.d(TAG, "onErrors: " + e.toString());
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: " + error.toString());
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

    /**
     * read product list from server using JsonObject Request
     * @param listener
     */
    private void readProductListFromServer(final IDataManager.OnProductListListener listener, String url_productlist) {
        Log.d(TAG, "readProductListFromServer: ");

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
                Log.d(TAG, "onErrorResponse: ");

                Product p
                        = new Product("id", "dress",
                        "10", "100", "description",
                        "https://rjtmobile.com/ansari/shopingcart/admin/uploads/product_images/images.jpg");

                productList.add(p);
                listener.bindProductsToView(productList);
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);



    }


    private void addOrderToServer(final IDataManager.OnOrderListener listener, String order_url) {


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                order_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponseOrder: ");
                try {
                    JSONArray jsonArray = response.getJSONArray("Order confirmed");

                    listener.isOrderPlacedSucessful(true);

                } catch (JSONException e) {
                    Log.d(TAG, "onError: ");
                    e.printStackTrace();
                    listener.isOrderPlacedSucessful(false);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: ");
                listener.isOrderPlacedSucessful(false);
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

}

