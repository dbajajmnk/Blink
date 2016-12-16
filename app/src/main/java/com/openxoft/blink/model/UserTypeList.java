package com.openxoft.blink.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserTypeList {

@SerializedName("USERTYPE_ID")
@Expose
private String uSERTYPEID;
@SerializedName("USERTYPE_NAME")
@Expose
private String uSERTYPENAME;

/**
* 
* @return
* The uSERTYPEID
*/
public String getUSERTYPEID() {
return uSERTYPEID;
}

/**
* 
* @param uSERTYPEID
* The USERTYPE_ID
*/
public void setUSERTYPEID(String uSERTYPEID) {
this.uSERTYPEID = uSERTYPEID;
}

/**
* 
* @return
* The uSERTYPENAME
*/
public String getUSERTYPENAME() {
return uSERTYPENAME;
}

/**
* 
* @param uSERTYPENAME
* The USERTYPE_NAME
*/
public void setUSERTYPENAME(String uSERTYPENAME) {
this.uSERTYPENAME = uSERTYPENAME;
}

}