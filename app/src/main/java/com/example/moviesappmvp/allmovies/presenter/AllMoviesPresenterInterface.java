package com.example.moviesappmvp.allmovies.presenter;

import com.example.moviesappmvp.model.Movie;

public interface AllMoviesPresenterInterface {

    //my two desired operations

    public void getMovies();

    public void addToFav(Movie movie);
}
