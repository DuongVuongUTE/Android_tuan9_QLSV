package com.example.qlsv_tuan9_t5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class LoadAppActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_app);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(com.example.qlsv_tuan9_t5.LoadAppActivity.this, com.example.qlsv_tuan9_t5.MainActivity.class);
                startActivity(intent);
            }
        },SPLASH_SCREEN);
    }
}