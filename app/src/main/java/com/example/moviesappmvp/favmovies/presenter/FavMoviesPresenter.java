package com.example.moviesappmvp.favmovies.presenter;

import androidx.lifecycle.LiveData;

import com.example.moviesappmvp.favmovies.view.FavViewInterface;
import com.example.moviesappmvp.model.Movie;
import com.example.moviesappmvp.model.RepositoryInterface;

import java.util.List;

public class FavMoviesPresenter implements FavMoviesPresenterInterface {
    RepositoryInterface _repo;
    FavViewInterface _view;

    public FavMoviesPresenter(FavViewInterface view, RepositoryInterface repo){
        this._view = view;
        this._repo = repo;
    }

    @Override
    public LiveData<List<Movie>> getMovies() {
        return _repo.getStoredMovies();
    }



    @Override
    public void deleteMovie(Movie movie) {
        _repo.deleteMovie(movie);

    }
}
