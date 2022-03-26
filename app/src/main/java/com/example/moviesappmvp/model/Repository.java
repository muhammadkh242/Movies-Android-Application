package com.example.moviesappmvp.model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.moviesappmvp.db.ConcreteLocalSource;
import com.example.moviesappmvp.db.LocalSource;
import com.example.moviesappmvp.network.MovieClient;
import com.example.moviesappmvp.network.NetworkDelegate;
import com.example.moviesappmvp.network.RemoteSource;

import java.util.List;

public class Repository implements RepositoryInterface{
    private Context context;

    private static Repository repo = null;
    LocalSource localSource;
    RemoteSource remoteSource;

    private Repository(Context context, LocalSource localSource, RemoteSource remoteSource){
        this.remoteSource = remoteSource;
        this.localSource = localSource;
        this.context = context;
    }

    public static Repository getInstance(Context context, LocalSource localSource, RemoteSource remoteSource){
        if(repo == null){
            repo = new Repository(context, localSource, remoteSource);
        }
        return repo;
    }



    @Override
    public void getAllMovies(NetworkDelegate networkDelegate) {
        remoteSource.enqueueCall(networkDelegate);
    }
    //???????????????????????????
    @Override
    public List<Movie> getLocalMovies() {
        return null;
    }

    @Override
    public LiveData<List<Movie>> getStoredMovies() {
        return localSource.geAllMovies();
    }

    @Override
    public void insertMovie(Movie movie) {
        localSource.insertMovie(movie);

    }

    @Override
    public void deleteMovie(Movie movie) {
        localSource.deleteMovie(movie);
    }
}
