package com.example.chad.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.chad.myapplication.R.id.amusements;
import static com.example.chad.myapplication.R.id.bandb;
import static com.example.chad.myapplication.R.id.breweries;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the amusements category
        TextView amusements = (TextView) findViewById(R.id.amusements);

        // Set a click listener on that View
        amusements.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the amusements category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link AmusementsActivity}
                Intent amusementsIntent = new Intent(MainActivity.this, AmusementsActivity.class);

                // Start the new activity
                startActivity(amusementsIntent);
            }
        });

        // Find the View that shows the BAndB category
        TextView bandb = (TextView) findViewById(R.id.bandb);

        // Set a click listener on that View
        bandb.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the bandb category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link BAndBActivity}
                Intent bandbIntent = new Intent(MainActivity.this, BAndBActivity.class);

                // Start the new activity
                startActivity(bandbIntent);
            }
        });

        // Find the View that shows the breweries category
        TextView breweries = (TextView) findViewById(R.id.breweries);

        // Set a click listener on that View
        breweries.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the breweries category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link BreweriesActivity}
                Intent breweriesIntent = new Intent(MainActivity.this, BreweriesActivity.class);

                // Start the new activity
                startActivity(breweriesIntent);
            }
        });

        // Find the View that shows the museums category
        TextView museums = (TextView) findViewById(R.id.museums);

        // Set a click listener on that View
        museums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the museums category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link MuseumsActivity}
                Intent museumsIntent = new Intent(MainActivity.this, MuseumsActivity.class);

                // Start the new activity
                startActivity(museumsIntent);
            }
        });
    }
}
