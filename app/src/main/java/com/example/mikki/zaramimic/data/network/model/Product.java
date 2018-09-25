package com.example.mikki.zaramimic.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable{
    String id, pname, quantity, prize, discription, image;
    int order_quantity;

    public Product(String id, String pname, String quantity, String prize, String discription, String image) {
        this.id = id;
        this.pname = pname;
        this.quantity = quantity;
        this.prize = prize;
        this.discription = discription;
        this.image = image;
        this.order_quantity = 0;
    }

    public String getId() {
        return id;
    }

    public String getPname() {
        return pname;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrize() {
        return prize;
    }

    public String getDiscription() {
        return discription;
    }

    public String getImage() {
        return image;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }

    /*---------------------------------------------------------------------------------------------
                                Parcelable Methods
         --------------------------------------------------------------------------------------------*/
    protected Product(Parcel in) {
        id = in.readString();
        pname = in.readString();
        quantity = in.readString();
        prize = in.readString();
        discription = in.readString();
        image = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(pname);
        dest.writeString(quantity);
        dest.writeString(prize);
        dest.writeString(discription);
        dest.writeString(image);
    }
}
