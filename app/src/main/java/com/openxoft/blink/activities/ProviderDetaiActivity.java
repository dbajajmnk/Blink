package com.openxoft.blink.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.openxoft.blink.R;


public class ProviderDetaiActivity extends BaseActivity {

    TextView mTitle,mService,mCity,mPax,mDate,mPrice,mDescription;
    ImageView mImage;
    Button mGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_detail);
        mTitle=(TextView)findViewById(R.id.tv_title);
        mService=(TextView)findViewById(R.id.tv_service);
        mCity=(TextView)findViewById(R.id.tv_city);
        mPax=(TextView)findViewById(R.id.tv_pax);
        mDate=(TextView)findViewById(R.id.tv_date);
        mPrice=(TextView)findViewById(R.id.tv_price);
        mDescription=(TextView)findViewById(R.id.tv_description);
        mImage=(ImageView)findViewById(R.id.iv_main);
        mGuest=(Button)findViewById(R.id.bt_guestdetail);
        mGuest.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        startActivity(new Intent(this,GuestDetailFormActivity.class));
    }
}
