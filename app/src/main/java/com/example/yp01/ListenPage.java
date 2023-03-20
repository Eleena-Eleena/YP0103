package com.example.yp01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class ListenPage extends AppCompatActivity {
    BottomNavigationFragment bottomNavigationFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_listen_page);
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.bottom_nav_id);
        if (fragment instanceof  Fragment)
        {
            bottomNavigationFragment = (BottomNavigationFragment) fragment;
            bottomNavigationFragment.initializeComponents();
        }
    }
}