package com.example.mikki.zaramimic.data.database.model;

/**
 * this is my pojo -- plain old java object
 */
public class TodoNote {
    String title;
    String subTitle;


    public TodoNote(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
