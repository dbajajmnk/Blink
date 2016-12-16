package com.openxoft.blink.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by openxoft on 18/11/16.
 */

public class NetUtil {

    public static  boolean isNetworkConnected(Context context)
    {
        ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null && networkInfo.isConnected() && networkInfo.isAvailable())
        {
            return true;
        }
        return false;
    }

}
