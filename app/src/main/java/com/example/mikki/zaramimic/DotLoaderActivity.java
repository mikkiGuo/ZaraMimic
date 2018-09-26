package com.example.mikki.zaramimic;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import steelkiwi.com.library.DotsLoaderView;

public class DotLoaderActivity extends AppCompatActivity {

    DotsLoaderView dotsLoaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dot_loader);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.5), (int)(height*.4));
        dotsLoaderView = findViewById(R.id.dotsLoader);

        downloadData();
    }

    private void downloadData() {
        AsyncTask<String,String,String> asyncTask = new AsyncTask<String, String, String>() {
            @Override
            protected void onPreExecute() {
                dotsLoaderView.show();
            }

            @Override
            protected String doInBackground(String... strings) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "done";
            }

            @Override
            protected void onPostExecute(String s) {
                if(s.equals("done")){
                    dotsLoaderView.hide();
                }
            }
        };
        asyncTask.execute();
    }
}
