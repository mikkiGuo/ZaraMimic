package com.example.mikki.zaramimic.data.database.model;

import android.provider.BaseColumns;

public class ShoppingCartTableContract {

    public ShoppingCartTableContract() {
    }

    /* Inner class that defines the table contents */
   public static abstract class ShoppingCartEntry implements BaseColumns {
        public static final String TABLE_NAME = "ShoppingCart";
        public static final String Pid = "pID";
        public static final String Pname = "pName";
        public static final String Pquantity = "pQuantity";
        public static final String Pprice = "pPrice";
        public static final String Pdiscription = "pDis";
        public static final String Pimage = "pImage";

    }

}
