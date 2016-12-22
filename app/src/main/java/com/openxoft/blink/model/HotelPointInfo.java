package com.openxoft.blink.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotelPointInfo {

    @SerializedName("HOTEL_NAME")
    @Expose
    private String hOTELNAME;
    @SerializedName("POINT")
    @Expose
    private String pOINT;

    public String getHOTELNAME() {
        return hOTELNAME;
    }

    public void setHOTELNAME(String hOTELNAME) {
        this.hOTELNAME = hOTELNAME;
    }

    public String getPOINT() {
        return pOINT;
    }

    public void setPOINT(String pOINT) {
        this.pOINT = pOINT;
    }
}
