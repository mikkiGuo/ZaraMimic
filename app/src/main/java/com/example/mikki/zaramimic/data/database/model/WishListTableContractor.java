package com.example.mikki.zaramimic.data.database.model;

import android.provider.BaseColumns;

public class WishListTableContractor {
    public WishListTableContractor() {
    }

    public static abstract class WishListEntry implements BaseColumns{
        public static final String TABLE_NAME = "WishList";
        public static final String Pid = "pID";
        public static final String Pname = "pName";
        public static final String Pquantity = "pQuantity";
        public static final String Pprice = "pPrice";
        public static final String Pdiscription = "pDis";
        public static final String Pimage = "pImage";
        public static final String Porder_quan = "pOrderQuantity";
    }
}
