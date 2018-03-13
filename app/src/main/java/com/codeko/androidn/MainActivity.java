package com.codeko.androidn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void guessTheCelebrity(View view) {
        Intent myIntent = new Intent(MainActivity.this, GuessTheCelebrityActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void whatsTheWeather(View view) {
        Intent myIntent = new Intent(MainActivity.this, WhatsThatWeatherActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void hikersWatch(View view) {
        Intent myIntent = new Intent(MainActivity.this, HikersWatchActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void memorablePlaces(View view) {
        Intent myIntent = new Intent(MainActivity.this, MemorablePlacesActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void notes(View view) {
        Intent myIntent = new Intent(MainActivity.this, NotesActivity.class);
        MainActivity.this.startActivity(myIntent);
    }
}
