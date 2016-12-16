package com.openxoft.blink.activities;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.openxoft.blink.R;
import com.openxoft.blink.util.NetUtil;
import com.openxoft.blink.util.Warning;

/**
 * Created by openxoft on 25/11/16.
 */
public class EnquiryActivity  extends BaseActivity{



    Button mSubmit;
    EditText mName,mEmail,mPhone,mSubject,mMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        initViews();


    }

    private void initViews() {
        mSubmit=(Button)findViewById(R.id.bt_submit);
        mName=(EditText)findViewById(R.id.et_name);
        mEmail=(EditText)findViewById(R.id.et_email);
        mPhone=(EditText)findViewById(R.id.et_phone);
        mSubject=(EditText)findViewById(R.id.et_subject);
        mMessage=(EditText)findViewById(R.id.et_msg);
        mSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        if(validateInput())
        {
            if(NetUtil.isNetworkConnected(this))
            {

            }

        }
    }

    private boolean validateInput() {

        if(mName.getText().toString().isEmpty())
        {
            mName.requestFocus();
            mName.setError(Warning.BLANK_FIELD);
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(mEmail.getText().toString()).matches())
        {
            mEmail.requestFocus();
            mEmail.setError(Warning.INVALID_EMAIL_ADDRESS);

        }
        else if(mPhone.getText().toString().isEmpty())
        {
            mPhone.requestFocus();
            mPhone.setError(Warning.BLANK_FIELD);

        }


        else if(mSubject.getText().toString().isEmpty())
        {
            mSubject.requestFocus();
            mSubject.setError(Warning.BLANK_FIELD);

        }
        else if(mMessage.getText().toString().isEmpty())
        {
            mMessage.requestFocus();
            mMessage.setError(Warning.BLANK_FIELD);

        }
        else {
            return true;
        }
        return false;
    }
}
