package com.example.moviesappmvp.favmovies.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.moviesappmvp.R;
import com.example.moviesappmvp.allmovies.presenter.AllMoviesPresenter;
import com.example.moviesappmvp.allmovies.vew.AllMoviesAdapter;
import com.example.moviesappmvp.db.ConcreteLocalSource;
import com.example.moviesappmvp.favmovies.presenter.FavMoviesPresenter;
import com.example.moviesappmvp.model.Movie;
import com.example.moviesappmvp.model.Repository;
import com.example.moviesappmvp.network.MovieClient;

import java.util.List;

public class FavActivity extends AppCompatActivity implements FavViewInterface, OnFavClickListener {
    RecyclerView favRecycler;
    FavAdapter adapter;
    FavMoviesPresenter favPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fav_screen);

        favRecycler = findViewById(R.id.favRecyclerview);

        adapter = new FavAdapter(this, this);

        //obtain layout manager to bind activity with recycler view
        LinearLayoutManager layoutManager = new LinearLayoutManager(FavActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //bind activity layout with recyclerview
        favRecycler.setLayoutManager(layoutManager);
        favPresenter = new FavMoviesPresenter(this, Repository.getInstance
                (this, ConcreteLocalSource.getInstance(this), MovieClient.getInstance()));
        favRecycler.setAdapter(adapter);
        favPresenter.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                adapter.setData(movies);
                adapter.notifyDataSetChanged();

            }
        });

    }

    @Override
    public void showFavData() {

    }

    @Override
    public void deleteMovie(Movie movie) {
        favPresenter.deleteMovie(movie);

    }

    @Override
    public void onClick(Movie movie) {
        deleteMovie(movie);

    }
}