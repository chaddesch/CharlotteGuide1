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

public class BAndBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);


        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<com.example.chad.myapplication.Location>();
        locations.add(new com.example.chad.myapplication.Location(R.string.elizabeth_name, R.string.elizabeth_details, R.string.elizabeth_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.aloft_name, R.string.aloft_details, R.string.aloft_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.duke_name, R.string.duke_details, R.string.duke_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.edna_name, R.string.edna_details, R.string.edna_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.matthews_name, R.string.matthews_details, R.string.matthews_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.morehead_name, R.string.morehead_details, R.string.morehead_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.elsie_name, R.string.elsie_details, R.string.elsie_address));
        locations.add(new com.example.chad.myapplication.Location(R.string.vanland_name, R.string.vanland_details, R.string.vanland_address));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(this, locations, R.color.category_bandb);

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