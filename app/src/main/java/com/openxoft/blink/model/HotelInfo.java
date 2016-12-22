package com.openxoft.blink.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotelInfo {

@SerializedName("ID")
@Expose
private Integer iD;
@SerializedName("HOTEL_NAME")
@Expose
private String hOTELNAME;
@SerializedName("ADDRESS")
@Expose
private String aDDRESS;
@SerializedName("ZIP")
@Expose
private String zIP;

public Integer getID() {
return iD;
}

public void setID(Integer iD) {
this.iD = iD;
}

public String getHOTELNAME() {
return hOTELNAME;
}

public void setHOTELNAME(String hOTELNAME) {
this.hOTELNAME = hOTELNAME;
}

public String getADDRESS() {
return aDDRESS;
}

public void setADDRESS(String aDDRESS) {
this.aDDRESS = aDDRESS;
}

public String getZIP() {
return zIP;
}

public void setZIP(String zIP) {
this.zIP = zIP;
}

}