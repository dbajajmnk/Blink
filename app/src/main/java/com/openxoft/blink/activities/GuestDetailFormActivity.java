package com.openxoft.blink.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.datetimepicker.time.RadialPickerLayout;
import com.android.datetimepicker.time.TimePickerDialog;
import com.openxoft.blink.R;

import java.text.DateFormat;
import java.util.Calendar;


public class GuestDetailFormActivity extends BaseActivity implements TimePickerDialog.OnTimeSetListener{

    EditText mTaBooking,mCellPhone,mFirstName,mMiddleName,mLastName,
            mAdult,mChild,mInfant,mFlightNumber,mHotelAddress,
            mZipCode,mOtherAddress,mOtherZipCode,mSpecialRequest;
    TextView mTotal,mArrivalTime;
    Spinner mHotel,mAirlineName,mAirPortCode,mTitle;
    Button mBookNow;
    RadioButton mDomestic,mInterNational;

    private Calendar calendar = Calendar.getInstance();
    private DateFormat dateFormat;
    private int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

    private int minute = calendar.get(Calendar.MINUTE);

    private int day = calendar.get(Calendar.DAY_OF_MONTH);

    private int month = calendar.get(Calendar.MONTH);

    private int year = calendar.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guestdetail);
        initViews();

    }
    private void initViews()
    {

        mTaBooking=(EditText)findViewById(R.id.et_tabooking);
        mCellPhone=(EditText)findViewById(R.id.et_cellnumber);
        mFirstName=(EditText)findViewById(R.id.et_firstname);
        mMiddleName=(EditText)findViewById(R.id.et_middlename);
        mLastName=(EditText)findViewById(R.id.et_lastname);
        mAdult=(EditText)findViewById(R.id.et_adult);
        mChild=(EditText)findViewById(R.id.et_child);
        mInfant=(EditText)findViewById(R.id.et_infant);
        mFlightNumber=(EditText)findViewById(R.id.et_flightno);

        mHotelAddress=(EditText)findViewById(R.id.et_hoteladdress);
        mZipCode=(EditText)findViewById(R.id.et_hotelzipcode);
        mOtherAddress=(EditText)findViewById(R.id.et_otheraddress);
        mOtherZipCode=(EditText)findViewById(R.id.et_otherzipcode);
        mSpecialRequest=(EditText)findViewById(R.id.et_specialreq);


        mTotal=(TextView)findViewById(R.id.tv_total);
        mArrivalTime=(TextView) findViewById(R.id.et_appivaltime);

        mAirlineName=(Spinner)findViewById(R.id.spin_airlinename);
        mAirPortCode=(Spinner)findViewById(R.id.spin_airportcode);
        mHotel=(Spinner)findViewById(R.id.spin_hotel);
        mTitle=(Spinner)findViewById(R.id.spin_title);
        mDomestic=(RadioButton)findViewById(R.id.rb_domestic);
        mInterNational=(RadioButton)findViewById(R.id.rb_international);
        mBookNow=(Button)findViewById(R.id.bt_booknow);
        mBookNow.setOnClickListener(this);
        mArrivalTime.setOnClickListener(this);






    }
    private void resetToTime() {
        mArrivalTime.setText(new StringBuilder().append(pad(hourOfDay))
                .append(":").append(pad(minute)));
        mArrivalTime.setTextColor(getResources().getColor(android.R.color.darker_gray));

    }



    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {

    }
    private static String pad3(int c) {
        if (c == 12)
            return " PM";
        if (c == 00)
            return " AM";
        if (c > 12)
            return " PM";
        else
            return " AM";
    }
    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
    private static String pad2(int c) {
        if (c == 12)
            return String.valueOf(c) ;
        if (c == 00)
            return String.valueOf(c+12) ;
        if (c > 12)
            return String.valueOf(c-12) ;
        else
            return String.valueOf(c);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId())
        {
            case R.id.et_appivaltime:
                TimePickerDialog.newInstance(this, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),false).show(this.getFragmentManager(), "timePicker");

                break;

        }
    }
}
