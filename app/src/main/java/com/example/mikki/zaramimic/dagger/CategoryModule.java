package com.example.mikki.zaramimic.dagger;

import android.content.Context;

import com.example.mikki.zaramimic.data.network.model.Category;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class CategoryModule {

    String cid, cname, cdiscription, cimagerl;

    public CategoryModule() {
    }

    public CategoryModule(String cid, String cname, String cdiscription, String cimagerl) {
        this.cid = cid;
        this.cname = cname;
        this.cdiscription = cdiscription;
        this.cimagerl = cimagerl;
    }

    @Provides
    Category getCategory(){

        return new Category(cid, cname, cdiscription, cimagerl);
    }
}
