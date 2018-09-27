package com.example.mikki.zaramimic.data.network;

public class URLKeeper {
    private static URLKeeper urlKeeper = new URLKeeper();

    public URLKeeper() {
    }

    static public URLKeeper getInstance(){
        return urlKeeper;
    }

    public String generateURLOrder(String item_id, String item_names, String item_quan, String fprice,
                                   String api_key, String user_id, String user_name,
                                   String billadd, String deliveryadd, String mobile, String email){

        String URL = "http://rjtmobile.com/aamir/e-commerce/android-app/orders.php?"
                + "&item_id=" + item_id +
                "&item_names=" + item_names +
                "&item_quantity=" + item_quan +
                "&final_price=" + fprice +
                "&&api_key=" + api_key +
                "&user_id=" + user_id +
                "&user_name=" + user_name +
                "&billingadd=" + billadd +
                "&deliveryadd=" + deliveryadd +
                "&mobile=" + mobile +
                "&email=" + email;
        return URL;
    }


}
