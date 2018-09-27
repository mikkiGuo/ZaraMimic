package com.example.mikki.zaramimic.dagger;

import com.example.mikki.zaramimic.data.network.NetworkHelper;

import javax.inject.Singleton;

import dagger.Component;

//wiring with injection
@Component(modules = {CategoryModule.class})
@Singleton
public interface MyComponent {

    //where to inject
    public void inject(NetworkHelper networkHelper);


}