package com.openxoft.blink.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AirPort {

@SerializedName("AIRPORT_ID")
@Expose
private Integer aIRPORTID;
@SerializedName("AIRPORT_CODE")
@Expose
private String aIRPORTCODE;

public Integer getAIRPORTID() {
return aIRPORTID;
}

public void setAIRPORTID(Integer aIRPORTID) {
this.aIRPORTID = aIRPORTID;
}

public String getAIRPORTCODE() {
return aIRPORTCODE;
}

public void setAIRPORTCODE(String aIRPORTCODE) {
this.aIRPORTCODE = aIRPORTCODE;
}

}