package com.example.chad.myapplication;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Chad on 10/19/2016.
 */

public class Location {

    /** Default translation for the word */
    private int mLocation;

    /** Miwok translation for the word */
    private int mLocationDetails;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**The address per location.*/
    private int mLocationAddress;

    /**The phone number per location.*/
    private int mLocationNumber;

    /**
     * Create a new Word object.
     *
     * @param location is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param locationDetails location's address
     */
    public Location(int location, int locationDetails, int locationAddress, int locationNumber) {
        mLocation = location;
        mLocationDetails = locationDetails;
        mLocationAddress = locationAddress;
        mLocationNumber = locationNumber;
    }

    /**
     * Create a new Word object.
     *
     * @param location is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param locationDetails is the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     */
    public Location(int location, int locationDetails, int imageResourceId, int locationAddress, int locationNumber) {
        mLocation = location;
        mLocationDetails = locationDetails;
        mImageResourceId = imageResourceId;
        mLocationAddress = locationAddress;
        mLocationNumber = locationNumber;
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

    public int getLocationAddress(){
        return mLocationAddress;
    }

    public int getLocationNumber(){
        return mLocationNumber;
    }
}
