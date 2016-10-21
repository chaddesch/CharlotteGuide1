package com.example.chad.myapplication;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Chad on 10/19/2016.
 */

public class Location {

    /**
     * Location name
     */
    private int mLocation;

    /**
     * Open hours or phone number for the locatio
     */
    private int mLocationDetails;

    /**
     * Image resource ID for the location
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided for this location
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * The address per location.
     */
    private int mLocationAddress;


    /**
     * Create a new Location object.
     *
     * @param location        is the name of the location
     * @param locationDetails is either the open hours or the phone number for the location
     * @param locationAddress is the address for the given location
     */
    public Location(int location, int locationDetails, int locationAddress) {
        mLocation = location;
        mLocationDetails = locationDetails;
        mLocationAddress = locationAddress;
    }

    /**
     * Create a new Word object.
     *
     * @param location        is the name of the location
     * @param locationDetails is either the open hours or the phone number for the location
     * @param locationAddress is the address for the given location
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     */
    public Location(int location, int locationDetails, int imageResourceId, int locationAddress) {
        mLocation = location;
        mLocationDetails = locationDetails;
        mImageResourceId = imageResourceId;
        mLocationAddress = locationAddress;
    }


    /**
     * Get the Location Name.
     */
    public int getLocation() {
        return mLocation;
    }

    /**
     * Get the Location Address.
     */
    public int getLocationDetails() {
        return mLocationDetails;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * @return location address
     */

    public int getLocationAddress() {
        return mLocationAddress;
    }

}
