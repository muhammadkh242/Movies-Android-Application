package com.example.moviesappmvp.favmovies.presenter;

import androidx.lifecycle.LiveData;

import com.example.moviesappmvp.model.Movie;

import java.util.List;

public interface FavMoviesPresenterInterface {
    //my two desired operations

    public LiveData<List<Movie>> getMovies();

    public void deleteMovie(Movie movie);
}
