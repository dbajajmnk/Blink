package com.openxoft.blink.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceResponse {

@SerializedName("Code")
@Expose
private String code;
@SerializedName("Response")
@Expose
private String response;
@SerializedName("Data")
@Expose
private List<Service> data = null;

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

public List<Service> getData() {
return data;
}

public void setData(List<Service> data) {
this.data = data;
}

}