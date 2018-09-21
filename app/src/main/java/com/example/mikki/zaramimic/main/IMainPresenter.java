package com.example.mikki.zaramimic.main;

import android.view.View;

public interface IMainPresenter {
    //execute this method at the same time as the related activity created.
    public void onActivityCreated();


    //test the connection of mvp framework
    public void connectToDb();
    public void onButtonClicked(View view);

}
