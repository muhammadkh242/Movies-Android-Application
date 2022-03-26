package com.example.moviesappmvp.model;


import android.graphics.Bitmap;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;
@Entity (tableName = "movies")
public class Movie {
    @PrimaryKey
    @ColumnInfo (name = "title")
    @NonNull
    private String title;

    @ColumnInfo (name = "image")
    private String image;

    @ColumnInfo (name = "rating")
    private float rating;

    @ColumnInfo (name = "releaseYear")
    private int releaseYear;




    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public float getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

}
