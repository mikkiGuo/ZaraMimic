package com.example.mikki.zaramimic.data.database;
import com.example.mikki.zaramimic.data.database.model.ShoppingCartTableContract.ShoppingCartEntry;
import com.example.mikki.zaramimic.data.database.model.WishListTableContractor.WishListEntry;
import com.example.mikki.zaramimic.data.database.model.UserProfileContractor.UserProfileEntry;

public class SqlQueries {
    private static SqlQueries sqLqueries = new SqlQueries();

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String OPEN_PARENTHESES = " (";
    private static final String CLOSE_PARENTHESES = ")";
    private static final String SINGLE_QUOTE = "'";
    private static final String SEMICOLUMN = ";";

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
                        ShoppingCartEntry.Pimage + TEXT_TYPE + COMMA_SEP +
                        ShoppingCartEntry.Porder_quantity+TEXT_TYPE+  " )";

        return SQL_CREATE_ENTRIES;
    }

    public String createWishListTable(){

        String wishListTable =
                "CREATE TABLE IF NOT EXISTS " + UserProfileEntry.TABLE_NAME + " (" +
                        UserProfileEntry._ID + " INTEGER PRIMARY KEY," +
                        UserProfileEntry.Uid + TEXT_TYPE + COMMA_SEP +
                        UserProfileEntry.Ufname + TEXT_TYPE + COMMA_SEP +
                        UserProfileEntry.Ulname + TEXT_TYPE + COMMA_SEP +
                        UserProfileEntry.Uemail + TEXT_TYPE + COMMA_SEP +
                        UserProfileEntry.Uphone + TEXT_TYPE + COMMA_SEP +
                        UserProfileEntry.Uaddress+TEXT_TYPE+  " )";

        return wishListTable;
    }

    public String createUserProfileTable(){
        String userProfileTable =
                "CREATE TABLE IF NOT EXISTS " + WishListEntry.TABLE_NAME + " (" +
                        WishListEntry._ID + " INTEGER PRIMARY KEY," +
                        WishListEntry.Pid + TEXT_TYPE + COMMA_SEP +
                        WishListEntry.Pname + TEXT_TYPE + COMMA_SEP +
                        WishListEntry.Pquantity + TEXT_TYPE + COMMA_SEP +
                        WishListEntry.Pprice + TEXT_TYPE + COMMA_SEP +
                        WishListEntry.Pdiscription + TEXT_TYPE + COMMA_SEP +
                        WishListEntry.Pimage+TEXT_TYPE+  " )";

        return userProfileTable;
    }

    public String readRowFromShoppingCartTable(String pID){

        String queries = "SELECT * FROM " + ShoppingCartEntry.TABLE_NAME
                + " WHERE " + ShoppingCartEntry.Pid
                + " = " + SINGLE_QUOTE + pID + SINGLE_QUOTE + SEMICOLUMN;

        return queries;
    }

    public String updatePorderQuantityInShoppingCartTable(String pID, String porderquantity){

        String queries = "UPDATE " + ShoppingCartEntry.TABLE_NAME
                + " SET " + ShoppingCartEntry.Porder_quantity
                + "=" + SINGLE_QUOTE + porderquantity + SINGLE_QUOTE
                + "WHERE " + ShoppingCartEntry.Pid
                + "=" + SINGLE_QUOTE + pID + SINGLE_QUOTE + SEMICOLUMN;
        return queries;
    }



}
