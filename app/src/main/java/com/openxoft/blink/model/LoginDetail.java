package com.openxoft.blink.model;

/**
 * Created by openxoft on 02/12/16.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LoginDetail {

    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Response")
    @Expose
    private String response;
    @SerializedName("Data")
    @Expose
    private User data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

}