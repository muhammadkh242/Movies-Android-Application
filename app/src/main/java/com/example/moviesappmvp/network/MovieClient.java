package com.example.moviesappmvp.network;

import com.example.moviesappmvp.model.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieClient implements RemoteSource{
    private static final String baseUrl = "https://api.androidhive.info/";
    private Retrofit retrofit;
    private static MovieClient client = null;

    private MovieClient(){}

    public static MovieClient getInstance(){
        if(client == null){
            client = new MovieClient();
        }
        return client;
    }


    @Override
    public void enqueueCall(NetworkDelegate networkDelegate) {
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(gson)).build();

        MovieService movieService = retrofit.create(MovieService.class);
        Call<List<Movie>> call = movieService.getMovies();

        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                networkDelegate.onSuccessfulResult(response.body());

            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                networkDelegate.onFailureResult(t.getCause().toString());

            }
        });

    }
}
