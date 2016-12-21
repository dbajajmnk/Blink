package com.openxoft.blink.api;

import com.google.android.gms.common.api.Api;
import com.openxoft.blink.model.GalleryData;
import com.openxoft.blink.model.LoginDetail;
import com.openxoft.blink.model.MainMenuResponse;
import com.openxoft.blink.model.Service;
import com.openxoft.blink.model.ServiceResponse;
import com.openxoft.blink.model.SignUpData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by openxoft on 29/11/16.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST(ApiParams.SUB_URL)
    Call<LoginDetail>getUserFromLogin(@Field(ApiParams.KEY_USER_NAME)String username, @Field(ApiParams.KEY_USER_PASSWORD)String password,@Field(ApiParams.TAG)String tag);
    @FormUrlEncoded
    @POST(ApiParams.SUB_URL)
   Call<SignUpData>getSignUpData(@Field(ApiParams.TAG)String tag);
    @FormUrlEncoded
    @POST(ApiParams.SUB_URL)
    Call<MainMenuResponse>getMenuSubMenuDetails(@Field(ApiParams.TAG)String tag, @Field(ApiParams.TAG_CITY_NAME)String cityName);
    @FormUrlEncoded
    @POST(ApiParams.SUB_URL)
    Call<ServiceResponse>makeSearch(@Field(ApiParams.TAG)String tag,
                                    @Field(ApiParams.KEY_USER_NAME)String userName,
                                    @Field(ApiParams.KEY_USER_PASSWORD)String userPassword,
                                    @Field(ApiParams.KEY_LOCATION)String location,
                                    @Field(ApiParams.KEY_CATEGORY_CODE)String categoryCode,
                                    @Field(ApiParams.KEY_SUB_CATEGORY_CODE)String subCategoryCode,
                                    @Field(ApiParams.KEY_FROM_DATE)String fromDate,
                                    @Field(ApiParams.KEY_PAX_TYPE)String paxType,
                                    @Field(ApiParams.KEY_NO_ADULT)String no_of_adult,
                                    @Field(ApiParams.KEY_NO_CHILD)String no_of_child,
                                    @Field(ApiParams.KEY_NO_INFANT)String no_of_infant,
                                    @Field(ApiParams.KEY_ACCESS_ID)String access_id

                                     );
    @FormUrlEncoded
    @POST(ApiParams.SUB_URL)
    Call<GalleryData>getServiceData(@Field(ApiParams.TAG)String tag,@Field(ApiParams.KEY_SERVICE_CODE)String serviceCode);


}
