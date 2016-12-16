package com.openxoft.blink.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationList {

@SerializedName("CITY")
@Expose
private String cITY;

/**
* 
* @return
* The cITY
*/
public String getCITY() {
return cITY;
}

/**
* 
* @param cITY
* The CITY
*/
public void setCITY(String cITY) {
this.cITY = cITY;
}

}