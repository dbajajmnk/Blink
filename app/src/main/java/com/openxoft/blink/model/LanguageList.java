package com.openxoft.blink.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LanguageList {

    @SerializedName("LNG_ID")
    @Expose
    private Integer lNGID;
    @SerializedName("LNG_LANGUAGE")
    @Expose
    private String lNGLANGUAGE;
    @SerializedName("LNG_CODE")
    @Expose
    private String lNGCODE;
    @SerializedName("LNG_LOCALE")
    @Expose
    private String lNGLOCALE;
    @SerializedName("LNG_FLAG")
    @Expose
    private String lNGFLAG;
    @SerializedName("LNG_ACTIVE")
    @Expose
    private Boolean lNGACTIVE;

    /**
     *
     * @return
     * The lNGID
     */
    public Integer getLNGID() {
        return lNGID;
    }

    /**
     *
     * @param lNGID
     * The LNG_ID
     */
    public void setLNGID(Integer lNGID) {
        this.lNGID = lNGID;
    }

    /**
     *
     * @return
     * The lNGLANGUAGE
     */
    public String getLNGLANGUAGE() {
        return lNGLANGUAGE;
    }

    /**
     *
     * @param lNGLANGUAGE
     * The LNG_LANGUAGE
     */
    public void setLNGLANGUAGE(String lNGLANGUAGE) {
        this.lNGLANGUAGE = lNGLANGUAGE;
    }

    /**
     *
     * @return
     * The lNGCODE
     */
    public String getLNGCODE() {
        return lNGCODE;
    }

    /**
     *
     * @param lNGCODE
     * The LNG_CODE
     */
    public void setLNGCODE(String lNGCODE) {
        this.lNGCODE = lNGCODE;
    }

    /**
     *
     * @return
     * The lNGLOCALE
     */
    public String getLNGLOCALE() {
        return lNGLOCALE;
    }

    /**
     *
     * @param lNGLOCALE
     * The LNG_LOCALE
     */
    public void setLNGLOCALE(String lNGLOCALE) {
        this.lNGLOCALE = lNGLOCALE;
    }

    /**
     *
     * @return
     * The lNGFLAG
     */
    public String getLNGFLAG() {
        return lNGFLAG;
    }

    /**
     *
     * @param lNGFLAG
     * The LNG_FLAG
     */
    public void setLNGFLAG(String lNGFLAG) {
        this.lNGFLAG = lNGFLAG;
    }

    /**
     *
     * @return
     * The lNGACTIVE
     */
    public Boolean getLNGACTIVE() {
        return lNGACTIVE;
    }

    /**
     *
     * @param lNGACTIVE
     * The LNG_ACTIVE
     */
    public void setLNGACTIVE(Boolean lNGACTIVE) {
        this.lNGACTIVE = lNGACTIVE;
    }

}