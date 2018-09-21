package com.example.mikki.zaramimic.data.network.model;

public class Coupon {

    String coupon_num, discount;

    public Coupon(String coupon_num, String discount) {
        this.coupon_num = coupon_num;
        this.discount = discount;
    }

    public String getCoupon_num() {
        return coupon_num;
    }

    public String getDiscount() {
        return discount;
    }
}
