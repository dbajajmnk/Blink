package com.openxoft.blink.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUpData {

    @SerializedName("CountryList")
    @Expose
    private List<CountryList> countryList = null;
    @SerializedName("LanguageList")
    @Expose
    private List<LanguageList> languageList = null;
    @SerializedName("LocationList")
    @Expose
    private List<LocationList> locationList = null;
    @SerializedName("UserTypeList")
    @Expose
    private List<UserTypeList> userTypeList = null;

    /**
     *
     * @return
     * The countryList
     */
    public List<CountryList> getCountryList() {
        return countryList;
    }

    /**
     *
     * @param countryList
     * The CountryList
     */
    public void setCountryList(List<CountryList> countryList) {
        this.countryList = countryList;
    }

    /**
     *
     * @return
     * The languageList
     */
    public List<LanguageList> getLanguageList() {
        return languageList;
    }

    /**
     *
     * @param languageList
     * The LanguageList
     */
    public void setLanguageList(List<LanguageList> languageList) {
        this.languageList = languageList;
    }

    /**
     *
     * @return
     * The locationList
     */
    public List<LocationList> getLocationList() {
        return locationList;
    }

    /**
     *
     * @param locationList
     * The LocationList
     */
    public void setLocationList(List<LocationList> locationList) {
        this.locationList = locationList;
    }

    /**
     *
     * @return
     * The userTypeList
     */
    public List<UserTypeList> getUserTypeList() {
        return userTypeList;
    }

    /**
     *
     * @param userTypeList
     * The UserTypeList
     */
    public void setUserTypeList(List<UserTypeList> userTypeList) {
        this.userTypeList = userTypeList;
    }

}