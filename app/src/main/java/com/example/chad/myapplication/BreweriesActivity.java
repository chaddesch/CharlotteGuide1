package com.example.chad.myapplication;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.button;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static java.lang.String.valueOf;

/**
 * Created by Chad on 10/18/2016.
 */

public class BreweriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);


        // Create a list of locations
        final ArrayList<com.example.chad.myapplication.Location> locations = new ArrayList<com.example.chad.myapplication.Location>();
        locations.add(new com.example.chad.myapplication.Location(R.string.birdsong_name, R.string.birdsong_details, R.drawable.birdsong, R.string.birdsong_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.blue_blaze_name, R.string.blue_blaze_details, R.drawable.blue_blaze, R.string.blue_blaze_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.heist_name, R.string.heist_details, R.drawable.heist, R.string.heist_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.lenny_boy_name, R.string.lenny_boy_details, R.drawable.lenny_boy, R.string.lenny_boy_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.noda_name, R.string.noda_details, R.drawable.noda, R.string.noda_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.omb_name, R.string.omb_details, R.drawable.omb, R.string.omb_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.rcc_name, R.string.rcc_details, R.drawable.rcc, R.string.rcc_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.sugar_creek_name, R.string.sugar_creek_details, R.drawable.sugar_creek, R.string.sugar_creek_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.sycamore_name, R.string.sycamore_details, R.drawable.sycamore, R.string.sycamore_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.triple_c_name, R.string.triple_c_details, R.drawable.triple_c, R.string.triple_c_address));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(this, locations, R.color.category_breweries);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // location_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        //Set an OnItemClickListener to grab the address per list_item and pass it through a Google Maps
        //Intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                com.example.chad.myapplication.Location location = locations.get(position);

                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + getString(location.getLocationAddress()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}

