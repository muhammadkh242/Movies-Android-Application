package com.example.moviesappmvp.allmovies.presenter;

import com.example.moviesappmvp.allmovies.vew.AllMoviesViewInterface;
import com.example.moviesappmvp.model.Movie;
import com.example.moviesappmvp.model.Repository;
import com.example.moviesappmvp.model.RepositoryInterface;
import com.example.moviesappmvp.network.NetworkDelegate;

import java.util.List;

public class AllMoviesPresenter implements AllMoviesPresenterInterface, NetworkDelegate {
    AllMoviesViewInterface _view;
    RepositoryInterface _repo;

    public AllMoviesPresenter(AllMoviesViewInterface view, RepositoryInterface repo){
        this._repo = repo;
        this._view = view;
    }



    @Override
    public void getMovies() {
        _repo.getAllMovies(this);

    }

    @Override
    public void addToFav(Movie movie) {
        _repo.insertMovie(movie);
    }

    @Override
    public void onSuccessfulResult(List<Movie> movieList) {
        _view.showData(movieList);

    }

    @Override
    public void onFailureResult(String errorMsg) {


    }
}
