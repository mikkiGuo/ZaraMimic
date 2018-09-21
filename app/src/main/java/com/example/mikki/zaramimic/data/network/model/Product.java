package com.example.mikki.zaramimic.data.network.model;

public class Product {
    String id, pname, quantity, prize, discription, image;

    public Product(String id, String pname, String quantity, String prize, String discription, String image) {
        this.id = id;
        this.pname = pname;
        this.quantity = quantity;
        this.prize = prize;
        this.discription = discription;
        this.image = image;
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
}
