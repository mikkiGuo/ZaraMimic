package com.example.mikki.zaramimic.data.network.model;

public class Order {
    String item_id, item_names, item_quantity, final_price,
            api_key, user_id, user_name, billingadd, deliveryadd,
            mobile, email;

    public Order(String item_id, String item_names,
                 String item_quantity) {
        this.item_id = item_id;
        this.item_names = item_names;
        this.item_quantity = item_quantity;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_names() {
        return item_names;
    }

    public void setItem_names(String item_names) {
        this.item_names = item_names;
    }

    public String getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(String item_quantity) {
        this.item_quantity = item_quantity;
    }

    public String getFinal_price() {
        return final_price;
    }

    public void setFinal_priceS(String item_price) {
        int price = Integer.parseInt(item_price);
        int quantity = Integer.parseInt(this.item_quantity);
        int total = price * quantity;
        this.final_price = String.valueOf(total);
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getBillingadd() {
        return billingadd;
    }

    public void setBillingadd(String billingadd) {
        this.billingadd = billingadd;
    }

    public String getDeliveryadd() {
        return deliveryadd;
    }

    public void setDeliveryadd(String deliveryadd) {
        this.deliveryadd = deliveryadd;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
