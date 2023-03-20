package com.example.yp01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    BottomNavigationFragment bottomNavigationFragment;

    public final String JSON_URL = "http://mskko2021.mad.hakta.pro/api/quotes/";

    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<model_Block> lstblock;
    private RecyclerView recyclerView;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getSupportActionBar().hide();
        ImageView imageViewMenu = findViewById(R.id.imageViewmenu);
        ImageView imageViewphoto = findViewById(R.id.imageViewPhoto);

        imageViewphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent intent = new Intent(getBaseContext(), Profile.class);
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

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.bottom_nav_id);
        if (fragment instanceof  Fragment)
        {
            bottomNavigationFragment = (BottomNavigationFragment) fragment;
            bottomNavigationFragment.initializeComponents();
        }

        lstblock = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleview);
       jsonrequest();


    }

    private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSONObject jsonObject = null;
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                jsonObject = response.getJSONObject(i);
                                model_Block books = new model_Block();
                                books.setTitle(jsonObject.getString("title"));
                                books.setDescription(jsonObject.getString("description"));
                                books.setmImage(jsonObject.getString("image"));

                                lstblock.add(books);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        setuprecycleview(lstblock);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue = Volley.newRequestQueue(HomePage.this);
        requestQueue.add(request);
    }


    private void setuprecycleview(List<model_Block> lstblock) {
        RecyclerViewAdapter madapter = new RecyclerViewAdapter(this,lstblock);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(madapter);
    }

}