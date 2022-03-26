package com.example.moviesappmvp.allmovies.vew;

import com.example.moviesappmvp.model.Movie;

import java.util.List;

public interface AllMoviesViewInterface {

    //two desired things to do in ui
    public void showData(List<Movie> movies);

    public void addMovie(Movie movie);
}
