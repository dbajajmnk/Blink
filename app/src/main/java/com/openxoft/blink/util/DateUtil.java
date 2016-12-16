package com.openxoft.blink.util;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by openxoft on 15/12/16.
 */

public class DateUtil {

    public static String pad3(int c) {
        if (c == 12)
            return " PM";
        if (c == 00)
            return " AM";
        if (c > 12)
            return " PM";
        else
            return " AM";
    }
    public static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
    public static String pad2(int c) {
        if (c == 12)
            return String.valueOf(c) ;
        if (c == 00)
            return String.valueOf(c+12) ;
        if (c > 12)
            return String.valueOf(c-12) ;
        else
            return String.valueOf(c);
    }
   public static void resetDate(Context context,TextView mDateView,Calendar calendar) {
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        mDateView.setText(new StringBuilder()
                .append(DateUtil.pad(month + 1)) .append(" ").append(DateUtil.pad(day)).append(" ").append(DateUtil.pad(year)));
        mDateView.setTextColor(context.getResources().getColor(android.R.color.holo_blue_light));

    }
}
