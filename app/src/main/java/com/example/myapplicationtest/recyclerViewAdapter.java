package com.example.myapplicationtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<topMovies> topMovies;

    public recyclerViewAdapter(Context ctx, List<topMovies> topMovies){
        this.inflater = LayoutInflater.from(ctx);
        this.topMovies= topMovies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.cardview_item_topmovies,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.movieTitle.setText(topMovies.get(position).getTitle());
        holder.movieYear.setText(topMovies.get(position).getYear());
        holder.movieRating.setText(topMovies.get(position).getIMDbRating());
        String[] img = topMovies.get(position).getImage().split("/");
        Picasso.get().load("https://imdb-api.com/Images/480x720/" + img[5]).into(holder.movieImg);
    }

    @Override
    public int getItemCount() {
        return topMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView movieTitle;
        ImageView movieImg;
        TextView movieYear;
        TextView movieRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            movieTitle = itemView.findViewById(R.id.movie_title);
            movieImg = itemView.findViewById(R.id.movie_img);
            movieYear = itemView.findViewById(R.id.movie_year);
            movieRating = itemView.findViewById(R.id.movie_rating);

        }
    }
}
