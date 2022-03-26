package com.example.moviesappmvp.db;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.moviesappmvp.model.Movie;
import com.example.moviesappmvp.network.MovieClient;

import java.util.List;

public class ConcreteLocalSource implements LocalSource{

    private MovieDao movieDao;
    private static ConcreteLocalSource localSource = null;
    private LiveData<List<Movie>> storedMovies;

    private ConcreteLocalSource(Context context){
        AppDataBase dataBase = AppDataBase.getInstance(context.getApplicationContext());
        movieDao = dataBase.movieDAO();
        storedMovies = movieDao.geAllMovies();

    }

    public static ConcreteLocalSource getInstance(Context context){
        if(localSource == null){
            localSource = new ConcreteLocalSource(context);
        }
        return localSource;
    }

    @Override
    public LiveData<List<Movie>> geAllMovies() {
        return storedMovies;
    }

    @Override
    public void insertMovie(Movie movie) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                movieDao.insertMovie(movie);
            }
        }).start();

    }

    @Override
    public void deleteMovie(Movie movie) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                movieDao.deleteMovie(movie);
            }
        }).start();

    }
}
