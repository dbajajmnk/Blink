package com.openxoft.blink.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MenuBaseClass {

@SerializedName("SER_LOCATIONID")
@Expose
private Integer sERLOCATIONID;
@SerializedName("MENUID")
@Expose
private Integer mENUID;
@SerializedName("MENU")
@Expose
private String mENU;
@SerializedName("SUBMENUID")
@Expose
private Integer sUBMENUID;
@SerializedName("SUBMENU")
@Expose
private String sUBMENU;

/**
* 
* @return
* The sERLOCATIONID
*/
public Integer getSERLOCATIONID() {
return sERLOCATIONID;
}

/**
* 
* @param sERLOCATIONID
* The SER_LOCATIONID
*/
public void setSERLOCATIONID(Integer sERLOCATIONID) {
this.sERLOCATIONID = sERLOCATIONID;
}

/**
* 
* @return
* The mENUID
*/
public Integer getMENUID() {
return mENUID;
}

/**
* 
* @param mENUID
* The MENUID
*/
public void setMENUID(Integer mENUID) {
this.mENUID = mENUID;
}

/**
* 
* @return
* The mENU
*/
public String getMENU() {
return mENU;
}

/**
* 
* @param mENU
* The MENU
*/
public void setMENU(String mENU) {
this.mENU = mENU;
}

/**
* 
* @return
* The sUBMENUID
*/
public Integer getSUBMENUID() {
return sUBMENUID;
}

/**
* 
* @param sUBMENUID
* The SUBMENUID
*/
public void setSUBMENUID(Integer sUBMENUID) {
this.sUBMENUID = sUBMENUID;
}

/**
* 
* @return
* The sUBMENU
*/
public String getSUBMENU() {
return sUBMENU;
}

/**
* 
* @param sUBMENU
* The SUBMENU
*/
public void setSUBMENU(String sUBMENU) {
this.sUBMENU = sUBMENU;
}

}