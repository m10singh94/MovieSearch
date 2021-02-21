package com.example.moviesearch;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MovieDes extends AppCompatActivity {

    private TextView titleMovie, yearMovie, directorMovie, ratingMovie, pageTitle, tvCountry, tvWriter;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_des);

        // gets the back button
        ImageButton backButton = findViewById(R.id.backButton);

        // attempts to set the back button image
        // sets the image for the logo from the assets.
        try {
            // gets the input stream, loads as drawable
            InputStream inputStream = getAssets().open("back_arrow.png");
            Drawable drawable = Drawable.createFromStream(inputStream, null);

            // sets the imageView image
            backButton.setImageDrawable(drawable);

            inputStream.close();
        }
        catch (IOException ex) {
            return;
        }

        // sets up the back button to go back
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // gets the page title
        pageTitle = findViewById(R.id.textTitle);

        // gets the title, year, review score and director of the movie from the intent
        titleMovie = findViewById(R.id.movTitle);
        yearMovie = findViewById(R.id.movYear);
        directorMovie = findViewById(R.id.movDirector);
        ratingMovie = findViewById(R.id.movReviewScore);
        tvCountry = findViewById(R.id.movCountry);
        tvWriter = findViewById(R.id.movWriter);

        // captures the intent from the other page
        Intent intent = getIntent();

        // sets the attributes on the page based on movie information
        String moTitle = intent.getStringExtra("mTitle");
        String moYear = intent.getStringExtra("mYear");
        String moDirector = intent.getStringExtra("mDirector");
        String moRating = intent.getStringExtra("mRating");
        String moCountry = intent.getStringExtra("mCountry");
        String moWriter = intent.getStringExtra("mWriter");

        // sets the actual text on the page using the attributes
        pageTitle.setText(moTitle);
        titleMovie.setText(moTitle);
        String text_year = "Released in " + moYear;
        yearMovie.setText(text_year);
        String text_director = "Directed by " + moDirector;
        directorMovie.setText(text_director);
        String text_rating = moRating + " Average Rating";
        ratingMovie.setText(text_rating);
        String text_country = "Country: " + moCountry;
        tvWriter.setText(text_country);
        String text_writer = "Written by " + moWriter;
        tvCountry.setText(text_writer);
    }
}