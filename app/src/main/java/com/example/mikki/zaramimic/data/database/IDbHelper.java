package com.example.mikki.zaramimic.data.database;

import com.example.mikki.zaramimic.data.IDataManager;
import com.example.mikki.zaramimic.data.database.model.TodoNote;




public interface IDbHelper {
    public void createRow(IDataManager.OnResponseListener listener);
    public void readRow();
    public void updateRow();
    public void deleteRow();
}
