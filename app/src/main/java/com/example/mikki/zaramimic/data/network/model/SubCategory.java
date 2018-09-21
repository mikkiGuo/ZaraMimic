package com.example.mikki.zaramimic.data.network.model;

public class SubCategory {

    String scid, scname, scdiscription,scimageurl;

    public SubCategory(String scid, String scname, String scdiscription, String scimageurl) {
        this.scid = scid;
        this.scname = scname;
        this.scdiscription = scdiscription;
        this.scimageurl = scimageurl;
    }

    public String getScid() {
        return scid;
    }

    public String getScname() {
        return scname;
    }

    public String getScdiscription() {
        return scdiscription;
    }

    public String getScimageurl() {
        return scimageurl;
    }
}
