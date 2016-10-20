package com.example.chad.myapplication;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

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
        locations.add(new com.example.chad.myapplication.Location(R.string.birdsong_name, R.string.birdsong_details, R.drawable.birdsong, R.string.birdsong_address, R.string.birdsong_number));
        //locations.add(new com.example.chad.myapplication.Location("Blue Blaze Brewing", "W 4-9pm, Th 4-10pm, F 4-11pm, Sa 12-11pm, Su 12-7pm", R.drawable.blue_blaze));
        //locations.add(new com.example.chad.myapplication.Location("Heist Brewery", "M-W 11-12am, Th-Sa 11-2am Su 10-12am", R.drawable.heist));
        //locations.add(new com.example.chad.myapplication.Location("Lenny Boy Brewing Co.", "W-Th 4-9pm, F 3-11pm, Sa 11am-11pm, Su 12-7pm", R.drawable.lenny_boy));
        //locations.add(new com.example.chad.myapplication.Location("Noda Brewing Co.", "M-Th 4-9pm, F 4-10pm, Sa 12-10pm, Su 12-7pm", R.drawable.noda));
        //locations.add(new com.example.chad.myapplication.Location("The Olde Mecklenburg Brewery", "Su-Th 11am-10pm, F-Sa 11am-11pm", R.drawable.omb));
        //locations.add(new com.example.chad.myapplication.Location("Red Clay Ciderworks", "W-Th 4-10pm, F 3-11pm, Sa 12-11pm, Su 12-8pm", R.drawable.rcc));
        //locations.add(new com.example.chad.myapplication.Location("Sugar Creek Brewing Co.", "M-W 4-9pm, Th 4-10pm, F 2-11pm, Sa 11am-11pm, Su 12-8pm", R.drawable.sugar_creek));
        //locations.add(new com.example.chad.myapplication.Location("Sycamore Brewing", "M-Th 4-10pm, F-Sa 12-11pm, Su 12-10pm", R.drawable.sycamore));
        //locations.add(new com.example.chad.myapplication.Location("Triple C Brewing Co.", "Tu-F 4-9pm, Sa 12-9pm, Su 12-8pm", R.drawable.triple_c));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(this, locations, R.color.category_breweries);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            }
        });
    }
}