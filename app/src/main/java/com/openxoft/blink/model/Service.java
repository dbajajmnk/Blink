package com.openxoft.blink.model;



import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Service implements Parcelable{

@SerializedName("code")
@Expose
private String code;
@SerializedName("service_id")
@Expose
private String serviceId;
@SerializedName("service_name")
@Expose
private String serviceName;
@SerializedName("from_date")
@Expose
private String fromDate;
@SerializedName("service_count")
@Expose
private String serviceCount;
@SerializedName("price_type")
@Expose
private String priceType;
@SerializedName("max_adult")
@Expose
private String maxAdult;
@SerializedName("max_child")
@Expose
private String maxChild;
@SerializedName("max_pax")
@Expose
private String maxPax;
@SerializedName("min_pax")
@Expose
private String minPax;
@SerializedName("amount")
@Expose
private String amount;
@SerializedName("status")
@Expose
private String status;
@SerializedName("c_service")
@Expose
private String cService;
@SerializedName("or_service")
@Expose
private String orService;
@SerializedName("noadult")
@Expose
private String noadult;
@SerializedName("nochild")
@Expose
private String nochild;
@SerializedName("max_cage")
@Expose
private String maxCage;
@SerializedName("min_cage")
@Expose
private String minCage;
@SerializedName("pid")
@Expose
private String pid;
@SerializedName("childprice")
@Expose
private String childprice;
@SerializedName("name_english")
@Expose
private String nameEnglish;
@SerializedName("name_french")
@Expose
private String nameFrench;
@SerializedName("name_italian")
@Expose
private String nameItalian;
@SerializedName("name_spanish")
@Expose
private String nameSpanish;
@SerializedName("description_english")
@Expose
private String descriptionEnglish;
@SerializedName("description_french")
@Expose
private String descriptionFrench;
@SerializedName("description_italian")
@Expose
private String descriptionItalian;
@SerializedName("description_spanish")
@Expose
private String descriptionSpanish;
@SerializedName("remarks_english")
@Expose
private String remarksEnglish;
@SerializedName("remarks_french")
@Expose
private String remarksFrench;
@SerializedName("remarks_italian")
@Expose
private String remarksItalian;
@SerializedName("remarks_spanish")
@Expose
private String remarksSpanish;
@SerializedName("add-ons")
@Expose
private String addOns;
@SerializedName("services_in_package")
@Expose
private String servicesInPackage;
@SerializedName("pick_details")
@Expose
private String pickDetails;
@SerializedName("drop_details")
@Expose
private String dropDetails;
@SerializedName("cancellation_policy")
@Expose
private String cancellationPolicy;
@SerializedName("image_path")
@Expose
private String imagePath;
@SerializedName("currency")
@Expose
private String currency;
@SerializedName("languages")
@Expose
private String languages;
@SerializedName("booking_allow")
@Expose
private String bookingAllow;
@SerializedName("category")
@Expose
private String category;
@SerializedName("subcategory")
@Expose
private String subcategory;
@SerializedName("service_Id_0")
@Expose
private Integer serviceId0;
@SerializedName("service_request_Id")
@Expose
private Integer serviceRequestId;

    protected Service(Parcel in) {
        code = in.readString();
        serviceId = in.readString();
        serviceName = in.readString();
        fromDate = in.readString();
        serviceCount = in.readString();
        priceType = in.readString();
        maxAdult = in.readString();
        maxChild = in.readString();
        maxPax = in.readString();
        minPax = in.readString();
        amount = in.readString();
        status = in.readString();
        cService = in.readString();
        orService = in.readString();
        noadult = in.readString();
        nochild = in.readString();
        maxCage = in.readString();
        minCage = in.readString();
        pid = in.readString();
        childprice = in.readString();
        nameEnglish = in.readString();
        nameFrench = in.readString();
        nameItalian = in.readString();
        nameSpanish = in.readString();
        descriptionEnglish = in.readString();
        descriptionFrench = in.readString();
        descriptionItalian = in.readString();
        descriptionSpanish = in.readString();
        remarksEnglish = in.readString();
        remarksFrench = in.readString();
        remarksItalian = in.readString();
        remarksSpanish = in.readString();
        addOns = in.readString();
        servicesInPackage = in.readString();
        pickDetails = in.readString();
        dropDetails = in.readString();
        cancellationPolicy = in.readString();
        imagePath = in.readString();
        currency = in.readString();
        languages = in.readString();
        bookingAllow = in.readString();
        category = in.readString();
        subcategory = in.readString();
    }

    public static final Creator<Service> CREATOR = new Creator<Service>() {
        @Override
        public Service createFromParcel(Parcel in) {
            return new Service(in);
        }

        @Override
        public Service[] newArray(int size) {
            return new Service[size];
        }
    };

    public String getCode() {
return code;
}

public void setCode(String code) {
this.code = code;
}

public String getServiceId() {
return serviceId;
}

public void setServiceId(String serviceId) {
this.serviceId = serviceId;
}

public String getServiceName() {
return serviceName;
}

public void setServiceName(String serviceName) {
this.serviceName = serviceName;
}

public String getFromDate() {
return fromDate;
}

public void setFromDate(String fromDate) {
this.fromDate = fromDate;
}

public String getServiceCount() {
return serviceCount;
}

public void setServiceCount(String serviceCount) {
this.serviceCount = serviceCount;
}

public String getPriceType() {
return priceType;
}

public void setPriceType(String priceType) {
this.priceType = priceType;
}

public String getMaxAdult() {
return maxAdult;
}

public void setMaxAdult(String maxAdult) {
this.maxAdult = maxAdult;
}

public String getMaxChild() {
return maxChild;
}

public void setMaxChild(String maxChild) {
this.maxChild = maxChild;
}

public String getMaxPax() {
return maxPax;
}

public void setMaxPax(String maxPax) {
this.maxPax = maxPax;
}

public String getMinPax() {
return minPax;
}

public void setMinPax(String minPax) {
this.minPax = minPax;
}

public String getAmount() {
return amount;
}

public void setAmount(String amount) {
this.amount = amount;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getCService() {
return cService;
}

public void setCService(String cService) {
this.cService = cService;
}

public String getOrService() {
return orService;
}

public void setOrService(String orService) {
this.orService = orService;
}

public String getNoadult() {
return noadult;
}

public void setNoadult(String noadult) {
this.noadult = noadult;
}

public String getNochild() {
return nochild;
}

public void setNochild(String nochild) {
this.nochild = nochild;
}

public String getMaxCage() {
return maxCage;
}

public void setMaxCage(String maxCage) {
this.maxCage = maxCage;
}

public String getMinCage() {
return minCage;
}

public void setMinCage(String minCage) {
this.minCage = minCage;
}

public String getPid() {
return pid;
}

public void setPid(String pid) {
this.pid = pid;
}

public String getChildprice() {
return childprice;
}

public void setChildprice(String childprice) {
this.childprice = childprice;
}

public String getNameEnglish() {
return nameEnglish;
}

public void setNameEnglish(String nameEnglish) {
this.nameEnglish = nameEnglish;
}

public String getNameFrench() {
return nameFrench;
}

public void setNameFrench(String nameFrench) {
this.nameFrench = nameFrench;
}

public String getNameItalian() {
return nameItalian;
}

public void setNameItalian(String nameItalian) {
this.nameItalian = nameItalian;
}

public String getNameSpanish() {
return nameSpanish;
}

public void setNameSpanish(String nameSpanish) {
this.nameSpanish = nameSpanish;
}

public String getDescriptionEnglish() {
return descriptionEnglish;
}

public void setDescriptionEnglish(String descriptionEnglish) {
this.descriptionEnglish = descriptionEnglish;
}

public String getDescriptionFrench() {
return descriptionFrench;
}

public void setDescriptionFrench(String descriptionFrench) {
this.descriptionFrench = descriptionFrench;
}

public String getDescriptionItalian() {
return descriptionItalian;
}

public void setDescriptionItalian(String descriptionItalian) {
this.descriptionItalian = descriptionItalian;
}

public String getDescriptionSpanish() {
return descriptionSpanish;
}

public void setDescriptionSpanish(String descriptionSpanish) {
this.descriptionSpanish = descriptionSpanish;
}

public String getRemarksEnglish() {
return remarksEnglish;
}

public void setRemarksEnglish(String remarksEnglish) {
this.remarksEnglish = remarksEnglish;
}

public String getRemarksFrench() {
return remarksFrench;
}

public void setRemarksFrench(String remarksFrench) {
this.remarksFrench = remarksFrench;
}

public String getRemarksItalian() {
return remarksItalian;
}

public void setRemarksItalian(String remarksItalian) {
this.remarksItalian = remarksItalian;
}

public String getRemarksSpanish() {
return remarksSpanish;
}

public void setRemarksSpanish(String remarksSpanish) {
this.remarksSpanish = remarksSpanish;
}

public String getAddOns() {
return addOns;
}

public void setAddOns(String addOns) {
this.addOns = addOns;
}

public String getServicesInPackage() {
return servicesInPackage;
}

public void setServicesInPackage(String servicesInPackage) {
this.servicesInPackage = servicesInPackage;
}

public String getPickDetails() {
return pickDetails;
}

public void setPickDetails(String pickDetails) {
this.pickDetails = pickDetails;
}

public String getDropDetails() {
return dropDetails;
}

public void setDropDetails(String dropDetails) {
this.dropDetails = dropDetails;
}

public String getCancellationPolicy() {
return cancellationPolicy;
}

public void setCancellationPolicy(String cancellationPolicy) {
this.cancellationPolicy = cancellationPolicy;
}

public String getImagePath() {
return imagePath;
}

public void setImagePath(String imagePath) {
this.imagePath = imagePath;
}

public String getCurrency() {
return currency;
}

public void setCurrency(String currency) {
this.currency = currency;
}

public String getLanguages() {
return languages;
}

public void setLanguages(String languages) {
this.languages = languages;
}

public String getBookingAllow() {
return bookingAllow;
}

public void setBookingAllow(String bookingAllow) {
this.bookingAllow = bookingAllow;
}

public String getCategory() {
return category;
}

public void setCategory(String category) {
this.category = category;
}

public String getSubcategory() {
return subcategory;
}

public void setSubcategory(String subcategory) {
this.subcategory = subcategory;
}

public Integer getServiceId0() {
return serviceId0;
}

public void setServiceId0(Integer serviceId0) {
this.serviceId0 = serviceId0;
}

public Integer getServiceRequestId() {
return serviceRequestId;
}

public void setServiceRequestId(Integer serviceRequestId) {
this.serviceRequestId = serviceRequestId;
}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(code);
        parcel.writeString(serviceId);
        parcel.writeString(serviceName);
        parcel.writeString(fromDate);
        parcel.writeString(serviceCount);
        parcel.writeString(priceType);
        parcel.writeString(maxAdult);
        parcel.writeString(maxChild);
        parcel.writeString(maxPax);
        parcel.writeString(minPax);
        parcel.writeString(amount);
        parcel.writeString(status);
        parcel.writeString(cService);
        parcel.writeString(orService);
        parcel.writeString(noadult);
        parcel.writeString(nochild);
        parcel.writeString(maxCage);
        parcel.writeString(minCage);
        parcel.writeString(pid);
        parcel.writeString(childprice);
        parcel.writeString(nameEnglish);
        parcel.writeString(nameFrench);
        parcel.writeString(nameItalian);
        parcel.writeString(nameSpanish);
        parcel.writeString(descriptionEnglish);
        parcel.writeString(descriptionFrench);
        parcel.writeString(descriptionItalian);
        parcel.writeString(descriptionSpanish);
        parcel.writeString(remarksEnglish);
        parcel.writeString(remarksFrench);
        parcel.writeString(remarksItalian);
        parcel.writeString(remarksSpanish);
        parcel.writeString(addOns);
        parcel.writeString(servicesInPackage);
        parcel.writeString(pickDetails);
        parcel.writeString(dropDetails);
        parcel.writeString(cancellationPolicy);
        parcel.writeString(imagePath);
        parcel.writeString(currency);
        parcel.writeString(languages);
        parcel.writeString(bookingAllow);
        parcel.writeString(category);
        parcel.writeString(subcategory);
    }
}