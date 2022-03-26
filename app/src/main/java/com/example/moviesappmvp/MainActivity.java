package com.example.moviesappmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moviesappmvp.allmovies.vew.AllMoviesActivity;
import com.example.moviesappmvp.favmovies.view.FavActivity;

public class MainActivity extends AppCompatActivity {

    Button allBtn;
    Button favBtn;
    Button exitBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allBtn = findViewById(R.id.allBtn);
        favBtn = findViewById(R.id.favBtn);
        exitBtn = findViewById(R.id.exitBtn);

        allBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllMoviesActivity.class);
                startActivity(intent);
            }
        });


        favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FavActivity.class);
                startActivity(intent);
            }
        });


        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}