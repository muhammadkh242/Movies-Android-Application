package com.example.moviesappmvp.network;

public interface RemoteSource {
    void enqueueCall(NetworkDelegate networkDelegate);
}
