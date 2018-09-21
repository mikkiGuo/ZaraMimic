package com.example.mikki.zaramimic.data.database.model;

import android.provider.BaseColumns;

public final class TodoContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public TodoContract() {}

    /* Inner class that defines the table contents */
    public static abstract class TodoEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";

    }
}