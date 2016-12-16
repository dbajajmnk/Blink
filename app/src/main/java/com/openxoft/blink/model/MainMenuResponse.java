package com.openxoft.blink.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainMenuResponse {

@SerializedName("Hotel")
@Expose
private List<MenuBaseClass> hotel = null;
@SerializedName("Transportation")
@Expose
private List<MenuBaseClass> transportation = null;
@SerializedName("Tours and Excursions")
@Expose
private List<MenuBaseClass> toursAndExcursions = null;
@SerializedName("Packages")
@Expose
private List<MenuBaseClass> packages = null;
@SerializedName("Entertainment & More")
@Expose
private List<MenuBaseClass> entertainmentMore = null;

/**
* 
* @return
* The hotel
*/
public List<MenuBaseClass> getHotel() {
return hotel;
}

/**
* 
* @param hotel
* The Hotel
*/
public void setHotel(List<MenuBaseClass> hotel) {
this.hotel = hotel;
}

/**
* 
* @return
* The transportation
*/
public List<MenuBaseClass> getTransportation() {
return transportation;
}

/**
* 
* @param transportation
* The Transportation
*/
public void setTransportation(List<MenuBaseClass> transportation) {
this.transportation = transportation;
}

/**
* 
* @return
* The toursAndExcursions
*/
public List<MenuBaseClass> getToursAndExcursions() {
return toursAndExcursions;
}

/**
* 
* @param toursAndExcursions
* The Tours and Excursions
*/
public void setToursAndExcursions(List<MenuBaseClass> toursAndExcursions) {
this.toursAndExcursions = toursAndExcursions;
}

/**
* 
* @return
* The packages
*/
public List<MenuBaseClass> getPackages() {
return packages;
}

/**
* 
* @param packages
* The Packages
*/
public void setPackages(List<MenuBaseClass> packages) {
this.packages = packages;
}

/**
* 
* @return
* The entertainmentMore
*/
public List<MenuBaseClass> getEntertainmentMore() {
return entertainmentMore;
}

/**
* 
* @param entertainmentMore
* The Entertainment & More
*/
public void setEntertainmentMore(List<MenuBaseClass> entertainmentMore) {
this.entertainmentMore = entertainmentMore;
}

}