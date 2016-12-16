package com.openxoft.blink.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.openxoft.blink.R;
import com.openxoft.blink.util.Utility;
import com.openxoft.blink.util.Warning;


public class ContactActivity extends BaseActivity {

    Button mCall, mWhatsApp, mEmail, mEnquiry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        initViews();

    }

    private void initViews() {
        mCall = (Button) findViewById(R.id.bt_call);
        mWhatsApp = (Button) findViewById(R.id.bt_whatsapp);
        mEmail = (Button) findViewById(R.id.bt_email);
        mEnquiry = (Button) findViewById(R.id.bt_enquiry);

        mCall.setOnClickListener(this);
        mWhatsApp.setOnClickListener(this);
        mEmail.setOnClickListener(this);
        mEnquiry.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.bt_call:
                makeCall();
                break;
            case R.id.bt_email:
                mailNow();
                break;
            case R.id.bt_enquiry:
                startActivity(new Intent(ContactActivity.this, EnquiryActivity.class));

                break;
            case R.id.bt_whatsapp:

                break;
        }
    }


    private void makeCall() {

        if(Utility.checkPhoneCallPermission(this))
        {

            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+"7291968552"));
            startActivity(intent);
        }

    }
    private void mailNow()
    {
        Intent intent=new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto","info@openxoft.com",null));
        startActivity(Intent.createChooser(intent,"Send Email..."));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case Utility.MY_PERMISSIONS_REQUEST_CALL_PHONE:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "7291968552"));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(this, Warning.DONT_HAVE_PHONECALL_PERMISSION,Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
