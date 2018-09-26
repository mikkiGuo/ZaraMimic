package com.example.mikki.zaramimic.data.database.model;

import android.provider.BaseColumns;

public class UserProfileContractor {

    public UserProfileContractor() {
    }

    public static abstract class UserProfileEntry implements BaseColumns {
        public static final String TABLE_NAME = "UserProfile";
        public static final String Uid = "userID";
        public static final String Ufname = "fname";
        public static final String Ulname = "lname";
        public static final String Uemail = "email";
        public static final String Uphone = "phone";
        public static final String Uaddress = "address";
    }

}
