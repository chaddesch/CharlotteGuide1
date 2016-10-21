package com.example.chad.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Chad on 10/21/2016.
 */

public class AmusementsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);


        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<com.example.chad.myapplication.Location>();
        locations.add(new com.example.chad.myapplication.Location(R.string.raptor_name, R.string.raptor_details, R.string.raptor_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.caro_name, R.string.caro_details, R.string.caro_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.garden_name, R.string.garden_details, R.string.garden_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.epicentre_name, R.string.epicentre_details, R.string.epicentre_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.muse_name, R.string.muse_details, R.string.muse_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.green_name, R.string.green_details, R.string.green_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.rural_name, R.string.rural_details, R.string.rural_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.imaginon_name, R.string.imaginon_details, R.string.imaginon_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.reed_name, R.string.reed_details, R.string.reed_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.usnwc_name, R.string.usnwc_details, R.string.usnwc_address));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(this, locations, R.color.category_amusements);

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