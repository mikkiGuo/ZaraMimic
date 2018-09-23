package com.example.mikki.zaramimic.category;

public interface ICategoryPresenter {
    public void onActivityCreated();
    public CategoryListAdapter.OnItemClickListener getItemClickListener();
}
