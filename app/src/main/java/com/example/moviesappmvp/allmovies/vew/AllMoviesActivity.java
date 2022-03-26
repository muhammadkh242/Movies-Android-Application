package com.example.moviesappmvp.allmovies.vew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.moviesappmvp.R;
import com.example.moviesappmvp.allmovies.presenter.AllMoviesPresenter;
import com.example.moviesappmvp.db.ConcreteLocalSource;
import com.example.moviesappmvp.model.Movie;
import com.example.moviesappmvp.model.Repository;
import com.example.moviesappmvp.network.MovieClient;

import java.util.List;

public class AllMoviesActivity extends AppCompatActivity implements AllMoviesViewInterface, OnMovieClickListener{
    RecyclerView allRecycler;
    AllMoviesAdapter adapter;
    AllMoviesPresenter allPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_screen);
        allRecycler = findViewById(R.id.allRecyclerview);

        adapter = new AllMoviesAdapter(this, this);

        //obtain layout manager to bind activity with recycler view
        LinearLayoutManager layoutManager = new LinearLayoutManager(AllMoviesActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //bind activity layout with recyclerview
        allRecycler.setLayoutManager(layoutManager);

        //bind adapter to recyclerview
        allRecycler.setAdapter(adapter);
        allPresenter = new AllMoviesPresenter(this, Repository.getInstance(AllMoviesActivity.this, ConcreteLocalSource.getInstance(this), MovieClient.getInstance()));
        allPresenter.getMovies();


    }

    @Override
    public void showData(List<Movie> movies) {
        adapter.setData(movies);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void addMovie(Movie movie) {
        allPresenter.addToFav(movie);

    }

    @Override
    public void onClick(Movie movie) {
        addMovie(movie);

    }
}