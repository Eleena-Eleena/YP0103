package com.example.yp01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MenuPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu_page);
    }
}