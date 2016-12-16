package com.openxoft.blink.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.openxoft.blink.R;
import com.openxoft.blink.util.NetUtil;
import com.openxoft.blink.util.Warning;


public class ChangePasswordActivity extends BaseActivity {

    EditText mCurrentPassword,mNewPassword,mConfirmPassword;
    Button mChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);

    }

    private void initViews()
    {
        mCurrentPassword=(EditText)findViewById(R.id.et_currentpassn);
        mNewPassword=(EditText)findViewById(R.id.et_newpassword);
        mConfirmPassword=(EditText)findViewById(R.id.et_confirmpassword);
        mChange=(Button)findViewById(R.id.bt_changepassword);
        mChange.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        if(validateInput())
        {
            if(NetUtil.isNetworkConnected(this))
            {
                if(validateInput())
                {

                }
            }
            else
            {
                Snackbar.make(view,Warning.NETWORK_PROBLEM,Snackbar.LENGTH_SHORT).show();
            }
        }
    }
    private boolean validateInput()
    {
        if(mCurrentPassword.getText().toString().isEmpty())
        {
                mCurrentPassword.setError(Warning.BLANK_FIELD);
                mCurrentPassword.requestFocus();
        }
        else if(mNewPassword.getText().toString().isEmpty())
        {
            mNewPassword.setError(Warning.BLANK_FIELD);
            mNewPassword.requestFocus();
        }
        else if (mConfirmPassword.getText().toString().isEmpty())
        {
            mConfirmPassword.setError(Warning.BLANK_FIELD);
            mConfirmPassword.requestFocus();
        }
        else
        {
            return true;
        }
        return false;
    }
}
