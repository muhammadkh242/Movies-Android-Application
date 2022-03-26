package com.example.moviesappmvp.network;

import com.example.moviesappmvp.model.Movie;

import java.util.List;

public interface NetworkDelegate {

    public void onSuccessfulResult(List<Movie> movieList);

    public void onFailureResult(String errorMsg);
}
