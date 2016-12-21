package com.openxoft.blink.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by openxoft on 21/12/16.
 */

public class ApiClient {

    public static final String BASE_URL="http://beta.opentourusa.com/";
    private static ApiService apiService;
    public static ApiService getApiClient()
    {
        if(apiService==null)
        {
         Retrofit   retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            apiService=retrofit.create(ApiService.class);
        }
        return apiService;
    }
}
