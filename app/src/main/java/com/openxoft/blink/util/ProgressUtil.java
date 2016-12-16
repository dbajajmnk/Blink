package com.openxoft.blink.util;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by openxoft on 28/11/16.
 */

public class ProgressUtil {

    private static ProgressDialog mProgressDialog;

    public static void showProgressDialog(Context context)
    {
        mProgressDialog=new ProgressDialog(context);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.show();
    }
    public  static void hideProgressDialog()
    {
        if(mProgressDialog!=null && mProgressDialog.isShowing())
        {
            mProgressDialog.dismiss();
        }
    }

}
