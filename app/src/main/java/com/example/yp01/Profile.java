package com.example.yp01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    RelativeLayout relativeLayout, relativeLayout1, relativeLayout2, relativeLayout3, relativeLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
        ImageView imageViewMenu = findViewById(R.id.imageViewmenu);
        TextView textViewEx = (TextView) findViewById(R.id.exit);
         relativeLayout = (RelativeLayout)findViewById(R.id.recycleCreate);
         relativeLayout1 = (RelativeLayout)findViewById(R.id.photo1);
         relativeLayout2 = (RelativeLayout)findViewById(R.id.photo2);
         relativeLayout3 = (RelativeLayout)findViewById(R.id.photo3);
         relativeLayout4 = (RelativeLayout)findViewById(R.id.photo4);
         relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PhotoPage.class);
                intent.putExtra("photo",1);
                startActivity(intent);
            }
        });
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PhotoPage.class);
                intent.putExtra("photo",2);
                startActivity(intent);
            }
        });
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PhotoPage.class);
                intent.putExtra("photo",3);
                startActivity(intent);
            }
        });


        relativeLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PhotoPage.class);
                intent.putExtra("photo",4);
                startActivity(intent);
            }
        });

        imageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MenuPage.class);
                startActivity(intent);
            }
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PhotoPage.class);
                intent.putExtra("photo",5);
                startActivity(intent);
            }
        });

        textViewEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SignIn.class);
                startActivity(intent);
            }
        });


    }
}