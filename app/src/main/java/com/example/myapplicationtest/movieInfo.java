package com.example.myapplicationtest;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

public class movieInfo extends AppCompatActivity {
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        Intent intent = getIntent();
        String movieid = intent.getStringExtra("infoid");
        String movieImg = intent.getStringExtra("infoimg");
        String Url = "https://imdb-api.com/en/API/Wikipedia/k_g74y0py7/" + movieid;
        String[] img = movieImg.split("/");
        ImageView imageView = findViewById(R.id.img_movie_info);
        Picasso.get().load("https://imdb-api.com/Images/480x720/" + img[5]).into(imageView);
        mQueue = Volley.newRequestQueue(this);
        jsonparseinfo(Url);
    }

    private void jsonparseinfo(String url) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            try {
                String movieInfo = response.getString("title");
                TextView txt_movie_info = findViewById(R.id.txt_movie_info);
                txt_movie_info.append(movieInfo);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, Throwable::printStackTrace);
        mQueue.add(request);
    }

}