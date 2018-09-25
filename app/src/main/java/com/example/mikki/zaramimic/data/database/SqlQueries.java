package com.example.mikki.zaramimic.data.database;
import com.example.mikki.zaramimic.data.database.model.ShoppingCartTableContract.ShoppingCartEntry;
import com.example.mikki.zaramimic.data.database.model.WishListTableContractor.WishListEntry;

public class SqlQueries {
    private static SqlQueries sqLqueries = new SqlQueries();

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    public SqlQueries() {
    }

    static public SqlQueries getInstance(){
        return sqLqueries;
    }

    public String createShoppingCartTable(){

        String SQL_CREATE_ENTRIES =
                "CREATE TABLE IF NOT EXISTS " + ShoppingCartEntry.TABLE_NAME + " (" +
                        ShoppingCartEntry._ID + " INTEGER PRIMARY KEY," +
                        ShoppingCartEntry.Pid + TEXT_TYPE + COMMA_SEP +
                        ShoppingCartEntry.Pname + TEXT_TYPE + COMMA_SEP +
                        ShoppingCartEntry.Pquantity + TEXT_TYPE + COMMA_SEP +
                        ShoppingCartEntry.Pprice + TEXT_TYPE + COMMA_SEP +
                        ShoppingCartEntry.Pdiscription + TEXT_TYPE + COMMA_SEP +
                        ShoppingCartEntry.Pimage+TEXT_TYPE+  " )";

        return SQL_CREATE_ENTRIES;
    }

    public String createWishListTable(){

        String wishListTable =
                "CREATE TABLE IF NOT EXISTS " + WishListEntry.TABLE_NAME + " (" +
                        WishListEntry._ID + " INTEGER PRIMARY KEY," +
                        WishListEntry.Pid + TEXT_TYPE + COMMA_SEP +
                        WishListEntry.Pname + TEXT_TYPE + COMMA_SEP +
                        WishListEntry.Pquantity + TEXT_TYPE + COMMA_SEP +
                        WishListEntry.Pprice + TEXT_TYPE + COMMA_SEP +
                        WishListEntry.Pdiscription + TEXT_TYPE + COMMA_SEP +
                        WishListEntry.Pimage+TEXT_TYPE+  " )";

        return wishListTable;
    }



}
