package com.openxoft.blink.model;

/**
 * Created by openxoft on 29/11/16.
 */


import com.google.gson.annotations.SerializedName;




        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class User {


    @SerializedName("Ul_ID")
    @Expose
    private String ulID;
    @SerializedName("UL_BID")
    @Expose
    private String uLBID;
    @SerializedName("UL_USERNAME")
    @Expose
    private String uLUSERNAME;
    @SerializedName("UL_ACCESSID")
    @Expose
    private String uLACCESSID;
    @SerializedName("UL_ISADMIN")
    @Expose
    private String uLISADMIN;
    @SerializedName("UL_ACTIVE")
    @Expose
    private String uLACTIVE;
    @SerializedName("UL_CODE")
    @Expose
    private String uLCODE;
    @SerializedName("UL_TITLE")
    @Expose
    private String uLTITLE;
    @SerializedName("UL_FIRSTNAME")
    @Expose
    private String uLFIRSTNAME;
    @SerializedName("UL_MIDDLENAME")
    @Expose
    private String uLMIDDLENAME;
    @SerializedName("UL_LASTNAME")
    @Expose
    private String uLLASTNAME;
    @SerializedName("UL_ADDRESS1")
    @Expose
    private String uLADDRESS1;
    @SerializedName("UL_ADDRESS2")
    @Expose
    private String uLADDRESS2;
    @SerializedName("UL_CITY")
    @Expose
    private String uLCITY;
    @SerializedName("UL_STATE")
    @Expose
    private String uLSTATE;
    @SerializedName("UL_ZIP")
    @Expose
    private String uLZIP;
    @SerializedName("UL_COUNTRY")
    @Expose
    private String uLCOUNTRY;
    @SerializedName("UL_FAX")
    @Expose
    private String uLFAX;
    @SerializedName("UL_EMAIL")
    @Expose
    private String uLEMAIL;
    @SerializedName("UL_PHONE")
    @Expose
    private String uLPHONE;
    @SerializedName("UL_MOBILE")
    @Expose
    private String uLMOBILE;
    @SerializedName("UL_EMPTYPE")
    @Expose
    private String uLEMPTYPE;
    @SerializedName("UL_H2H")
    @Expose
    private String uLH2H;
    @SerializedName("UL_URL")
    @Expose
    private String uLURL;
    @SerializedName("UL_PREFERREDLANG")
    @Expose
    private String uLPREFERREDLANG;
    @SerializedName("UL_PAYTPE")
    @Expose
    private String uLPAYTPE;
    @SerializedName("UL_MARKUP")
    @Expose
    private String uLMARKUP;
    @SerializedName("UL_ACCEMAIL")
    @Expose
    private String uLACCEMAIL;

    /**
     *
     * @return
     * The ulID
     */
    public String getUlID() {
        return ulID;
    }

    /**
     *
     * @param ulID
     * The Ul_ID
     */
    public void setUlID(String ulID) {
        this.ulID = ulID;
    }

    /**
     *
     * @return
     * The uLBID
     */
    public String getULBID() {
        return uLBID;
    }

    /**
     *
     * @param uLBID
     * The UL_BID
     */
    public void setULBID(String uLBID) {
        this.uLBID = uLBID;
    }

    /**
     *
     * @return
     * The uLUSERNAME
     */
    public String getULUSERNAME() {
        return uLUSERNAME;
    }

    /**
     *
     * @param uLUSERNAME
     * The UL_USERNAME
     */
    public void setULUSERNAME(String uLUSERNAME) {
        this.uLUSERNAME = uLUSERNAME;
    }

    /**
     *
     * @return
     * The uLACCESSID
     */
    public String getULACCESSID() {
        return uLACCESSID;
    }

    /**
     *
     * @param uLACCESSID
     * The UL_ACCESSID
     */
    public void setULACCESSID(String uLACCESSID) {
        this.uLACCESSID = uLACCESSID;
    }

    /**
     *
     * @return
     * The uLISADMIN
     */
    public String getULISADMIN() {
        return uLISADMIN;
    }

    /**
     *
     * @param uLISADMIN
     * The UL_ISADMIN
     */
    public void setULISADMIN(String uLISADMIN) {
        this.uLISADMIN = uLISADMIN;
    }

    /**
     *
     * @return
     * The uLACTIVE
     */
    public String getULACTIVE() {
        return uLACTIVE;
    }

    /**
     *
     * @param uLACTIVE
     * The UL_ACTIVE
     */
    public void setULACTIVE(String uLACTIVE) {
        this.uLACTIVE = uLACTIVE;
    }

    /**
     *
     * @return
     * The uLCODE
     */
    public String getULCODE() {
        return uLCODE;
    }

    /**
     *
     * @param uLCODE
     * The UL_CODE
     */
    public void setULCODE(String uLCODE) {
        this.uLCODE = uLCODE;
    }

    /**
     *
     * @return
     * The uLTITLE
     */
    public String getULTITLE() {
        return uLTITLE;
    }

    /**
     *
     * @param uLTITLE
     * The UL_TITLE
     */
    public void setULTITLE(String uLTITLE) {
        this.uLTITLE = uLTITLE;
    }

    /**
     *
     * @return
     * The uLFIRSTNAME
     */
    public String getULFIRSTNAME() {
        return uLFIRSTNAME;
    }

    /**
     *
     * @param uLFIRSTNAME
     * The UL_FIRSTNAME
     */
    public void setULFIRSTNAME(String uLFIRSTNAME) {
        this.uLFIRSTNAME = uLFIRSTNAME;
    }

    /**
     *
     * @return
     * The uLMIDDLENAME
     */
    public String getULMIDDLENAME() {
        return uLMIDDLENAME;
    }

    /**
     *
     * @param uLMIDDLENAME
     * The UL_MIDDLENAME
     */
    public void setULMIDDLENAME(String uLMIDDLENAME) {
        this.uLMIDDLENAME = uLMIDDLENAME;
    }

    /**
     *
     * @return
     * The uLLASTNAME
     */
    public String getULLASTNAME() {
        return uLLASTNAME;
    }

    /**
     *
     * @param uLLASTNAME
     * The UL_LASTNAME
     */
    public void setULLASTNAME(String uLLASTNAME) {
        this.uLLASTNAME = uLLASTNAME;
    }

    /**
     *
     * @return
     * The uLADDRESS1
     */
    public String getULADDRESS1() {
        return uLADDRESS1;
    }

    /**
     *
     * @param uLADDRESS1
     * The UL_ADDRESS1
     */
    public void setULADDRESS1(String uLADDRESS1) {
        this.uLADDRESS1 = uLADDRESS1;
    }

    /**
     *
     * @return
     * The uLADDRESS2
     */
    public String getULADDRESS2() {
        return uLADDRESS2;
    }

    /**
     *
     * @param uLADDRESS2
     * The UL_ADDRESS2
     */
    public void setULADDRESS2(String uLADDRESS2) {
        this.uLADDRESS2 = uLADDRESS2;
    }

    /**
     *
     * @return
     * The uLCITY
     */
    public String getULCITY() {
        return uLCITY;
    }

    /**
     *
     * @param uLCITY
     * The UL_CITY
     */
    public void setULCITY(String uLCITY) {
        this.uLCITY = uLCITY;
    }

    /**
     *
     * @return
     * The uLSTATE
     */
    public String getULSTATE() {
        return uLSTATE;
    }

    /**
     *
     * @param uLSTATE
     * The UL_STATE
     */
    public void setULSTATE(String uLSTATE) {
        this.uLSTATE = uLSTATE;
    }

    /**
     *
     * @return
     * The uLZIP
     */
    public String getULZIP() {
        return uLZIP;
    }

    /**
     *
     * @param uLZIP
     * The UL_ZIP
     */
    public void setULZIP(String uLZIP) {
        this.uLZIP = uLZIP;
    }

    /**
     *
     * @return
     * The uLCOUNTRY
     */
    public String getULCOUNTRY() {
        return uLCOUNTRY;
    }

    /**
     *
     * @param uLCOUNTRY
     * The UL_COUNTRY
     */
    public void setULCOUNTRY(String uLCOUNTRY) {
        this.uLCOUNTRY = uLCOUNTRY;
    }

    /**
     *
     * @return
     * The uLFAX
     */
    public String getULFAX() {
        return uLFAX;
    }

    /**
     *
     * @param uLFAX
     * The UL_FAX
     */
    public void setULFAX(String uLFAX) {
        this.uLFAX = uLFAX;
    }

    /**
     *
     * @return
     * The uLEMAIL
     */
    public String getULEMAIL() {
        return uLEMAIL;
    }

    /**
     *
     * @param uLEMAIL
     * The UL_EMAIL
     */
    public void setULEMAIL(String uLEMAIL) {
        this.uLEMAIL = uLEMAIL;
    }

    /**
     *
     * @return
     * The uLPHONE
     */
    public String getULPHONE() {
        return uLPHONE;
    }

    /**
     *
     * @param uLPHONE
     * The UL_PHONE
     */
    public void setULPHONE(String uLPHONE) {
        this.uLPHONE = uLPHONE;
    }

    /**
     *
     * @return
     * The uLMOBILE
     */
    public String getULMOBILE() {
        return uLMOBILE;
    }

    /**
     *
     * @param uLMOBILE
     * The UL_MOBILE
     */
    public void setULMOBILE(String uLMOBILE) {
        this.uLMOBILE = uLMOBILE;
    }

    /**
     *
     * @return
     * The uLEMPTYPE
     */
    public String getULEMPTYPE() {
        return uLEMPTYPE;
    }

    /**
     *
     * @param uLEMPTYPE
     * The UL_EMPTYPE
     */
    public void setULEMPTYPE(String uLEMPTYPE) {
        this.uLEMPTYPE = uLEMPTYPE;
    }

    /**
     *
     * @return
     * The uLH2H
     */
    public String getULH2H() {
        return uLH2H;
    }

    /**
     *
     * @param uLH2H
     * The UL_H2H
     */
    public void setULH2H(String uLH2H) {
        this.uLH2H = uLH2H;
    }

    /**
     *
     * @return
     * The uLURL
     */
    public String getULURL() {
        return uLURL;
    }

    /**
     *
     * @param uLURL
     * The UL_URL
     */
    public void setULURL(String uLURL) {
        this.uLURL = uLURL;
    }

    /**
     *
     * @return
     * The uLPREFERREDLANG
     */
    public String getULPREFERREDLANG() {
        return uLPREFERREDLANG;
    }

    /**
     *
     * @param uLPREFERREDLANG
     * The UL_PREFERREDLANG
     */
    public void setULPREFERREDLANG(String uLPREFERREDLANG) {
        this.uLPREFERREDLANG = uLPREFERREDLANG;
    }

    /**
     *
     * @return
     * The uLPAYTPE
     */
    public String getULPAYTPE() {
        return uLPAYTPE;
    }

    /**
     *
     * @param uLPAYTPE
     * The UL_PAYTPE
     */
    public void setULPAYTPE(String uLPAYTPE) {
        this.uLPAYTPE = uLPAYTPE;
    }

    /**
     *
     * @return
     * The uLMARKUP
     */
    public String getULMARKUP() {
        return uLMARKUP;
    }

    /**
     *
     * @param uLMARKUP
     * The UL_MARKUP
     */
    public void setULMARKUP(String uLMARKUP) {
        this.uLMARKUP = uLMARKUP;
    }

    /**
     *
     * @return
     * The uLACCEMAIL
     */
    public String getULACCEMAIL() {
        return uLACCEMAIL;
    }

    /**
     *
     * @param uLACCEMAIL
     * The UL_ACCEMAIL
     */
    public void setULACCEMAIL(String uLACCEMAIL) {
        this.uLACCEMAIL = uLACCEMAIL;
    }

}