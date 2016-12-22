package com.openxoft.blink.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckOutFormData {

@SerializedName("ImageGalleryData")
@Expose
private List<String> imageGalleryData = null;
@SerializedName("AirlineData")
@Expose
private List<Airline> airlineData = null;
@SerializedName("AirPortData")
@Expose
private List<AirPort> airPortData = null;
@SerializedName("HotelInfoData")
@Expose
private List<HotelInfo> hotelInfoData = null;
@SerializedName("HotelPointInfoData")
@Expose
private List<HotelPointInfo> hotelPointInfoData = null;
@SerializedName("PickUpDropUpConditionData")
@Expose
private List<PickUpDropUpConditionDatum> pickUpDropUpConditionData = null;

public List<String> getImageGalleryData() {
return imageGalleryData;
}

public void setImageGalleryData(List<String> imageGalleryData) {
this.imageGalleryData = imageGalleryData;
}

public List<Airline> getAirlineData() {
return airlineData;
}

public void setAirlineData(List<Airline> airlineData) {
this.airlineData = airlineData;
}

public List<AirPort> getAirPortData() {
return airPortData;
}

public void setAirPortData(List<AirPort> airPortData) {
this.airPortData = airPortData;
}

public List<HotelInfo> getHotelInfoData() {
return hotelInfoData;
}

public void setHotelInfoData(List<HotelInfo> hotelInfoData) {
this.hotelInfoData = hotelInfoData;
}

public List<HotelPointInfo> getHotelPointInfoData() {
return hotelPointInfoData;
}

public void setHotelPointInfoData(List<HotelPointInfo> hotelPointInfoData) {
this.hotelPointInfoData = hotelPointInfoData;
}

public List<PickUpDropUpConditionDatum> getPickUpDropUpConditionData() {
return pickUpDropUpConditionData;
}

public void setPickUpDropUpConditionData(List<PickUpDropUpConditionDatum> pickUpDropUpConditionData) {
this.pickUpDropUpConditionData = pickUpDropUpConditionData;
}

}