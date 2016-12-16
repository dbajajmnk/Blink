package com.openxoft.blink.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.health.ServiceHealthStats;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;

import java.util.Set;

/**
 * Created by openxoft on 21/11/16.
 */

public class PrefUtil {

    public static void putString(Context context, String fileName,String keyName,String keyValue)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(fileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(keyName,keyValue);
        editor.commit();
    }
    public static void putInt(Context context, String fileName,String keyName,int keyValue)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(fileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(keyName,keyValue);
        editor.commit();
    }
    public static void putFloat(Context context, String fileName,String keyName,float keyValue)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(fileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putFloat(keyName,keyValue);
        editor.commit();
    }
    public static void putBoolean(Context context, String fileName,String keyName,boolean keyValue)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(fileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(keyName,keyValue);
        editor.commit();
    }
    public static void putLong(Context context, String fileName,String keyName,long keyValue)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(fileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putLong(keyName,keyValue);
        editor.commit();
    }
    public static void putSet(Context context, String fileName,String keyName,Set<String> keyValue)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(fileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putStringSet(keyName,keyValue);
        editor.commit();
    }
    public static String getString(Context context,String fileName,String keyName)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(fileName,context.MODE_PRIVATE);
        return sharedPreferences.getString(keyName,null);
    }
    public static int getInt(Context context,String fileName,String keyName)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(fileName,context.MODE_PRIVATE);
        return sharedPreferences.getInt(keyName,-1);
    }
    public static boolean getBoolean(Context context,String fileName,String keyName)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(fileName,context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(keyName,false);
    }
    public static float getFloat(Context context,String fileName,String keyName)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(fileName,context.MODE_PRIVATE);
        return sharedPreferences.getFloat(keyName,-1);
    }
    public static Long getLong(Context context,String fileName,String keyName)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(fileName,context.MODE_PRIVATE);
        return sharedPreferences.getLong(keyName,-1);
    }
    public static Set<String> getSet(Context context,String fileName,String keyName)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(fileName,context.MODE_PRIVATE);
        return sharedPreferences.getStringSet(keyName,null);
    }
    public static void clearString(Context context,String fileName,String keyName)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(fileName,context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}
