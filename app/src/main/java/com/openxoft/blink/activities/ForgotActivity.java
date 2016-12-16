package com.openxoft.blink.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.openxoft.blink.R;
import com.openxoft.blink.util.NetUtil;
import com.openxoft.blink.util.Warning;

/**
 * Created by openxoft on 18/11/16.
 */

public class ForgotActivity extends BaseActivity{


    Button mSend;
    EditText mEmailAddress,mUserId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        initViews();
    }
    private void initViews()
    {
        mEmailAddress=(EditText)findViewById(R.id.et_email);
        mUserId=(EditText)findViewById(R.id.et_userid);
        mSend=(Button)findViewById(R.id.bt_send);
        mSend.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        if(validateInput())
        {
          if(NetUtil.isNetworkConnected(this))
          {

          }
            else {

                  Snackbar.make(view,Warning.NETWORK_PROBLEM,Snackbar.LENGTH_SHORT).show();

          }
        }

    }

    private boolean validateInput()
    {
        if(mUserId.getText().toString().isEmpty())
        {
            mUserId.requestFocus();
            mUserId.setError(Warning.BLANK_FIELD);

        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(mEmailAddress.getText().toString()).matches())
        {
            mEmailAddress.requestFocus();
            mEmailAddress.setError(Warning.INVALID_EMAIL_ADDRESS);
        }
        else
        {
            return true;
        }
        return false;

    }
}
