package com.example.myapplicationtest;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class movieInfo extends AppCompatActivity {
    private RequestQueue mQueue;
    List<topMovies> topMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        Intent intent = getIntent();
        String movieid = intent.getStringExtra("infoid");
        String movieImg = intent.getStringExtra("infoimg");
        String Url = "https://imdb-api.com/en/API/Wikipedia/k_g74y0py7/" + movieid;

        mQueue = Volley.newRequestQueue(this);
        topMovies = new ArrayList<>();
        jsonparseinfo(Url);
    }

    private void jsonparseinfo(String url) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            try {
                String movieInfo = response.getString("titleInLanguage");
                TextView txt_movie_info = findViewById(R.id.txt_movie_info);
                txt_movie_info.append(movieInfo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> error.printStackTrace());
        mQueue.add(request);
    }

}