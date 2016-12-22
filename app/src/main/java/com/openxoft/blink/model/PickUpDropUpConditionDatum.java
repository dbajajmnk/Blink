package com.openxoft.blink.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PickUpDropUpConditionDatum {

    @SerializedName("AirportPickup")
    @Expose
    private Boolean airportPickup;
    @SerializedName("HotelPickup")
    @Expose
    private Boolean hotelPickup;
    @SerializedName("PointPickup")
    @Expose
    private Boolean pointPickup;
    @SerializedName("OtherPickup")
    @Expose
    private Boolean otherPickup;
    @SerializedName("AirportDrop")
    @Expose
    private Boolean airportDrop;
    @SerializedName("HotelDrop")
    @Expose
    private Boolean hotelDrop;
    @SerializedName("PointDrop")
    @Expose
    private Boolean pointDrop;
    @SerializedName("OtherDrop")
    @Expose
    private Boolean otherDrop;

    public Boolean getAirportPickup() {
        return airportPickup;
    }

    public void setAirportPickup(Boolean airportPickup) {
        this.airportPickup = airportPickup;
    }

    public Boolean getHotelPickup() {
        return hotelPickup;
    }

    public void setHotelPickup(Boolean hotelPickup) {
        this.hotelPickup = hotelPickup;
    }

    public Boolean getPointPickup() {
        return pointPickup;
    }

    public void setPointPickup(Boolean pointPickup) {
        this.pointPickup = pointPickup;
    }

    public Boolean getOtherPickup() {
        return otherPickup;
    }

    public void setOtherPickup(Boolean otherPickup) {
        this.otherPickup = otherPickup;
    }

    public Boolean getAirportDrop() {
        return airportDrop;
    }

    public void setAirportDrop(Boolean airportDrop) {
        this.airportDrop = airportDrop;
    }

    public Boolean getHotelDrop() {
        return hotelDrop;
    }

    public void setHotelDrop(Boolean hotelDrop) {
        this.hotelDrop = hotelDrop;
    }

    public Boolean getPointDrop() {
        return pointDrop;
    }

    public void setPointDrop(Boolean pointDrop) {
        this.pointDrop = pointDrop;
    }

    public Boolean getOtherDrop() {
        return otherDrop;
    }

    public void setOtherDrop(Boolean otherDrop) {
        this.otherDrop = otherDrop;
    }
}