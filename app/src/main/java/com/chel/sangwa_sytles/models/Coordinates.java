
package com.chel.sangwa_sytles.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel
public class Coordinates {

    @SerializedName("latitude")
    @Expose
    public Double latitude;
    @SerializedName("longitude")
    @Expose
    public Double longitude;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Coordinates() {
    }

    /**
     * 
     * @param longitude
     * @param latitude
     */
    public Coordinates(Double latitude, Double longitude) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
