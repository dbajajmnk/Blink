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
    @SerializedName("UserDetails")
    @Expose
    private User userDetails;

    /**
     *
     * @return
     * The code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The Code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The response
     */
    public String getResponse() {
        return response;
    }

    /**
     *
     * @param response
     * The Response
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     *
     * @return
     * The userDetails
     */
    public User getUserDetails() {
        return userDetails;
    }

    /**
     *
     * @param userDetails
     * The UserDetails
     */
    public void setUserDetails(User userDetails) {
        this.userDetails = userDetails;
    }

}
