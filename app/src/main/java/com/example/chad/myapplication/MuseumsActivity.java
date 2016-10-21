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

public class MuseumsActivity extends AppCompatActivity {

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.location_list);


    // Create a list of locations
    final ArrayList<Location> locations = new ArrayList<com.example.chad.myapplication.Location>();
    locations.add(new com.example.chad.myapplication.Location(R.string.bechtler_name, R.string.birdsong_details, R.string.birdsong_address));
    locations.add(new com.example.chad.myapplication.Location(R.string.billy_g_name, R.string.blue_blaze_details, R.string.blue_blaze_address));
    locations.add(new com.example.chad.myapplication.Location(R.string.aviation_name, R.string.heist_details, R.string.heist_address));
    locations.add(new com.example.chad.myapplication.Location(R.string.discovery_name, R.string.lenny_boy_details, R.string.lenny_boy_address));
    locations.add(new com.example.chad.myapplication.Location(R.string.nature_name, R.string.noda_details, R.string.noda_address));
    locations.add(new com.example.chad.myapplication.Location(R.string.levine_name, R.string.omb_details, R.string.omb_address));
    locations.add(new com.example.chad.myapplication.Location(R.string.mint_name, R.string.rcc_details, R.string.rcc_address));
    locations.add(new com.example.chad.myapplication.Location(R.string.nascar_name, R.string.sugar_creek_details, R.string.sugar_creek_address));


    // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}s. The
    // adapter knows how to create list items for each item in the list.
    LocationAdapter adapter = new LocationAdapter(this, locations, R.color.category_museums);

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

            Uri gmmIntentUri = Uri.parse("geo:0,0?q="+getString(location.getLocationAddress()));
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
    });
}
}