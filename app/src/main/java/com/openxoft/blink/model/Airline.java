package com.openxoft.blink.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Airline {

@SerializedName("AL_ID")
@Expose
private Integer aLID;
@SerializedName("AL_CODE")
@Expose
private String aLCODE;
@SerializedName("AL_NAME")
@Expose
private String aLNAME;

public Integer getALID() {
return aLID;
}

public void setALID(Integer aLID) {
this.aLID = aLID;
}

public String getALCODE() {
return aLCODE;
}

public void setALCODE(String aLCODE) {
this.aLCODE = aLCODE;
}

public String getALNAME() {
return aLNAME;
}

public void setALNAME(String aLNAME) {
this.aLNAME = aLNAME;
}

}