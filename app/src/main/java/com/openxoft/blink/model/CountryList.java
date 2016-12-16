package com.openxoft.blink.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryList {

@SerializedName("CTY_ID")
@Expose
private String cTYID;
@SerializedName("CTY_NAME")
@Expose
private String cTYNAME;

/**
* 
* @return
* The cTYID
*/
public String getCTYID() {
return cTYID;
}

/**
* 
* @param cTYID
* The CTY_ID
*/
public void setCTYID(String cTYID) {
this.cTYID = cTYID;
}

/**
* 
* @return
* The cTYNAME
*/
public String getCTYNAME() {
return cTYNAME;
}

/**
* 
* @param cTYNAME
* The CTY_NAME
*/
public void setCTYNAME(String cTYNAME) {
this.cTYNAME = cTYNAME;
}

}