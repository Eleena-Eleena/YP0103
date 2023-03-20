package com.example.yp01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PhotoPage extends AppCompatActivity {
    Button delete, back;
    private final int GALLERY_REQ_CODE = 1000;
    private boolean isImageScaled = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_photo_page);
        Button create = findViewById(R.id.btn_Create);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        int photo = getIntent().getExtras().getInt("photo");
        loadphoto(photo);

        delete = findViewById(R.id.btn_Del);
        back = findViewById(R.id.btn_Back);

        imageView.setOnClickListener(v -> {
            if (!isImageScaled) v.animate().scaleX(1.4f).scaleY(1.4f).setDuration(500);
            if (isImageScaled) v.animate().scaleX(1f).scaleY(1f).setDuration(500);
            isImageScaled = !isImageScaled;
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGallery = new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery, GALLERY_REQ_CODE);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "@drawable/recycle";
                int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                Drawable res = getResources().getDrawable(imageResource);
                imageView.setImageDrawable(res);
                Toast.makeText(getApplicationContext(), "Изображение удалено", Toast.LENGTH_LONG).show();

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Profile.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        if (resultCode==RESULT_OK)
        {
            if (requestCode==GALLERY_REQ_CODE)
            {
                imageView.setImageURI(data.getData());
                Toast.makeText(getApplicationContext(), "Изображение загружено", Toast.LENGTH_LONG).show();

            }
        }
    }

    private void loadphoto(int photo) {
        ImageView imageView = (ImageView) findViewById(R.id.image);
        if (photo == 1) {
            String uri = "@drawable/photo3";
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            imageView.setImageDrawable(res);
        } else if (photo == 2) {
            String uri = "@drawable/photo2";
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            imageView.setImageDrawable(res);
        } else if (photo == 3) {
            String uri = "@drawable/photo4";
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            imageView.setImageDrawable(res);
        } else if (photo == 4) {
            String uri = "@drawable/photo5";
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            imageView.setImageDrawable(res);
        } else {
            Button create = findViewById(R.id.btn_Create);
            create.setVisibility(create.VISIBLE);
            String uri = "@drawable/recycle";
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            imageView.setImageDrawable(res);

        }

    }
}