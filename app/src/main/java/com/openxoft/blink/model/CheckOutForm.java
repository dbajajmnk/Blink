package com.openxoft.blink.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckOutForm {

@SerializedName("Code")
@Expose
private String code;
@SerializedName("Response")
@Expose
private String response;
@SerializedName("Data")
@Expose
private CheckOutFormData data;

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

public CheckOutFormData getData() {
return data;
}

public void setData(CheckOutFormData data) {
this.data = data;
}

}