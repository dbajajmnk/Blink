package com.openxoft.blink.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GalleryIcon {

@SerializedName("OriginalPath")
@Expose
private String originalPath;
@SerializedName("FullPath")
@Expose
private String fullPath;

public String getOriginalPath() {
return originalPath;
}

public void setOriginalPath(String originalPath) {
this.originalPath = originalPath;
}

public String getFullPath() {
return fullPath;
}

public void setFullPath(String fullPath) {
this.fullPath = fullPath;
}

}