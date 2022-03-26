package com.example.moviesappmvp.db;

import androidx.lifecycle.LiveData;

import com.example.moviesappmvp.model.Movie;

import java.util.List;

public interface LocalSource {
    LiveData<List<Movie>> geAllMovies();
    void insertMovie(Movie movie);
    void deleteMovie(Movie movie);

}
