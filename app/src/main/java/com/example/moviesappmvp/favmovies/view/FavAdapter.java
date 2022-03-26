package com.example.moviesappmvp.favmovies.view;

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

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {
    private Context context;
    private List<Movie> movies = new ArrayList<>();
    private OnFavClickListener onFavClickListener;

    public FavAdapter(Context context, OnFavClickListener onFavClickListener) {
        this.context = context;
        this.onFavClickListener = onFavClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.favmovie_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Movie movie = movies.get(position);
        holder.getTitleTxt().setText(movie.getTitle());
        holder.getYearTxt().setText(String.valueOf(movie.getReleaseYear()));
        holder.getRatingBar().setRating(movie.getRating());
        Glide.with(context).load(movie.getImage()).into(holder.imageView);
        holder.getDeleteBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFavClickListener.onClick(movie);
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
        Button deleteBtn;
        View row;

        public ViewHolder(@NonNull View convertView) {
            super(convertView);
            row = convertView;
            titleTxt = row.findViewById(R.id.titleTxt);
            yearTxt = row.findViewById(R.id.yearTxt);
            imageView = row.findViewById(R.id.imageView);
            ratingBar = row.findViewById(R.id.ratingBar);
            deleteBtn = row.findViewById(R.id.deleteBtn);
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

        public Button getDeleteBtn() {
            return deleteBtn;
        }
    }
}
