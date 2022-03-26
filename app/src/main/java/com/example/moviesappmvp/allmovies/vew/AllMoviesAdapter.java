package com.example.moviesappmvp.allmovies.vew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesappmvp.R;
import com.example.moviesappmvp.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class AllMoviesAdapter extends RecyclerView.Adapter<AllMoviesAdapter.ViewHolder>{
    private Context context;
    private List<Movie> movies = new ArrayList<>();
    private OnMovieClickListener onMovieClickListener;

    public AllMoviesAdapter(Context context, OnMovieClickListener onMovieClickListener) {
        this.context = context;
        this.onMovieClickListener = onMovieClickListener;
    }

    @NonNull
    @Override
    public AllMoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_row, parent, false);
        AllMoviesAdapter.ViewHolder viewHolder = new AllMoviesAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AllMoviesAdapter.ViewHolder holder, int position) {

        Movie movie = movies.get(position);
        holder.getTitleTxt().setText(movie.getTitle());
        holder.getYearTxt().setText(String.valueOf(movie.getReleaseYear()));
        holder.getRatingBar().setRating(movie.getRating());
        Glide.with(context).load(movie.getImage()).into(holder.imageView);
        holder.getAddBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMovieClickListener.onClick(movie);
            }
        });

    }
    public void setData(List<Movie> movies){
        this.movies = movies;
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt;
        TextView yearTxt;
        ImageView imageView;
        RatingBar ratingBar;
        Button addBtn;
        View row;

        public ViewHolder(@NonNull View convertView) {
            super(convertView);
            row = convertView;
            titleTxt = row.findViewById(R.id.titleTxt);
            yearTxt = row.findViewById(R.id.yearTxt);
            imageView = row.findViewById(R.id.imageView);
            ratingBar = row.findViewById(R.id.ratingBar);
            addBtn = row.findViewById(R.id.addBtn);
        }

        public TextView getTitleTxt() {
            return titleTxt;
        }

        public TextView getYearTxt() {
            return yearTxt;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public RatingBar getRatingBar() {
            return ratingBar;
        }

        public Button getAddBtn() {
            return addBtn;
        }
    }
}
