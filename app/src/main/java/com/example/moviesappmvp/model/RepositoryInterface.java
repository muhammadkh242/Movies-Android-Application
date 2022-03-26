package com.example.moviesappmvp.model;

import androidx.lifecycle.LiveData;

import com.example.moviesappmvp.network.NetworkDelegate;

import java.util.List;

public interface RepositoryInterface {

    //from network
    void getAllMovies(NetworkDelegate networkDelegate);


    //???????????????????????????
    //static movies
    List<Movie> getLocalMovies();

    //room-stored movies
    LiveData<List<Movie>> getStoredMovies();

    void insertMovie(Movie movie);

    void deleteMovie(Movie movie);

}
