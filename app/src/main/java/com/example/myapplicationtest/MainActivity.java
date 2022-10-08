package com.example.myapplicationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<topMovies> topMovies;
    private RequestQueue mQueue;
    private static final String URL = "https://imdb-api.com/en/API/Top250Movies/k_g74y0py7";
    recyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_topMovies);
        mQueue = Volley.newRequestQueue(this);
        topMovies = new ArrayList<>();
        jsonparse();



    }

    private void jsonparse() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null,
                response -> {
                    try {
                        JSONArray jsonArray = response.getJSONArray("items");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject data = jsonArray.getJSONObject(i);

                            topMovies movies = new topMovies();
                            movies.setTitle(data.getString("title"));
                            movies.setYear(data.getString("year"));
                            movies.setImage(data.getString("image"));
                            movies.setIMDbRating(data.getString("imDbRating"));
                            movies.setId(data.getString("id"));

                            topMovies.add(movies);
                        }
                        topMovies.sort((topMovies1, topMovies2) -> topMovies1.Year.compareToIgnoreCase(topMovies2.Year));
                        Collections.reverse(topMovies);

                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        recyclerViewAdapter = new recyclerViewAdapter(getApplicationContext(),topMovies);
                        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,3));
                        recyclerView.setAdapter(recyclerViewAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, Throwable::printStackTrace);
        mQueue.add(request);
    }
}