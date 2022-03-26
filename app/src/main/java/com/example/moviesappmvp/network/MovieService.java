package com.example.moviesappmvp.network;

import com.example.moviesappmvp.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {
    @GET("json/movies.json")
    Call<List<Movie>> getMovies();
}
