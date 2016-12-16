package com.openxoft.blink.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.openxoft.blink.R;
import com.openxoft.blink.adapter.CountyAdapter;
import com.openxoft.blink.adapter.LanguageAdapter;
import com.openxoft.blink.adapter.UserTypeAdapter;
import com.openxoft.blink.api.ApiParams;
import com.openxoft.blink.api.ApiService;
import com.openxoft.blink.model.SignUpData;
import com.openxoft.blink.util.PrefUtil;
import com.openxoft.blink.util.ProgressUtil;
import com.openxoft.blink.util.Warning;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by openxoft on 18/11/16.
 */

public class SignUpActivity extends BaseActivity {

    Spinner mLoginType, mCountry, mLanguage;

    EditText mFirstName, mLastName, mMiddleName, mCompanyName, mAddress, mCity, mState, mZipCode, mCellNumber, mFax, mEmailAddress, mLoginId, mPhoneNumber;
    Button mSignup;
    CheckBox mEmail, mFaxCheck, mAllBooking, mRQAServices, mAgreement;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initViews();

    }

    private void initViews() {


        //Spinners
        mLanguage = (Spinner) findViewById(R.id.spin_language);
        mLoginType = (Spinner) findViewById(R.id.spin_logintype);
        mCountry = (Spinner) findViewById(R.id.spin_selectcountry);
        //Input Fields
        mFirstName = (EditText) findViewById(R.id.et_firstname);
        mMiddleName = (EditText) findViewById(R.id.et_middlename);
        mLastName = (EditText) findViewById(R.id.et_lastname);
        mCompanyName = (EditText) findViewById(R.id.et_companyname);
        mAddress = (EditText) findViewById(R.id.et_address);
        mCity = (EditText) findViewById(R.id.et_city);
        mState = (EditText) findViewById(R.id.et_state);
        mZipCode = (EditText) findViewById(R.id.et_zipcode);
        mCellNumber = (EditText) findViewById(R.id.et_cellnumber);
        mFax = (EditText) findViewById(R.id.et_fax);
        mEmailAddress = (EditText) findViewById(R.id.et_email);
        mLoginId = (EditText) findViewById(R.id.et_loginid);
        mPhoneNumber = (EditText) findViewById(R.id.et_phone_number);

        //Check Boxs
        mEmail = (CheckBox) findViewById(R.id.cb_email);
        mFaxCheck = (CheckBox) findViewById(R.id.cb_fax);
        mAllBooking = (CheckBox) findViewById(R.id.cb_allbookings);
        mRQAServices = (CheckBox) findViewById(R.id.cb_rqservices);
        mAgreement = (CheckBox) findViewById(R.id.cb_agree);

        mEmail.setOnCheckedChangeListener(this);
        mFaxCheck.setOnCheckedChangeListener(this);
        mAllBooking.setOnCheckedChangeListener(this);
        mRQAServices.setOnCheckedChangeListener(this);
        mAgreement.setOnCheckedChangeListener(this);


        //Buttons
        mSignup = (Button) findViewById(R.id.bt_singup);
        mSignup.setOnClickListener(this);
        SignUpData signUpData = new Gson().fromJson(PrefUtil.getString(SignUpActivity.this, ApiParams.SINGUP_DATA, ApiParams.SINGUP_DATA), SignUpData.class);
            fillData(signUpData);





    }

    private boolean validateInput() {
        if (mLoginId.getText().toString().isEmpty()) {
            mLoginId.requestFocus();
            mLoginId.setError(Warning.BLANK_FIELD);

        }
        if (mFirstName.getText().toString().isEmpty()) {
            mFirstName.requestFocus();
            mFirstName.setError(Warning.BLANK_FIELD);

        } else if (mLastName.getText().toString().isEmpty()) {
            mFirstName.requestFocus();
            mFirstName.setError(Warning.BLANK_FIELD);

        } else if (mCompanyName.getText().toString().isEmpty()) {
            mCompanyName.requestFocus();
            mCompanyName.setError(Warning.BLANK_FIELD);

        } else if (mAddress.getText().toString().isEmpty()) {
            mAddress.requestFocus();
            mAddress.setError(Warning.BLANK_FIELD);


        } else if (mCity.getText().toString().isEmpty()) {
            mCity.requestFocus();
            mCity.setError(Warning.BLANK_FIELD);


        } else if (mZipCode.getText().toString().isEmpty()) {
            mZipCode.requestFocus();
            mZipCode.setError(Warning.BLANK_FIELD);


        } else if (!Patterns.EMAIL_ADDRESS.matcher(mEmailAddress.getText().toString()).matches()) {
            mEmailAddress.requestFocus();
            mEmailAddress.setError(Warning.INVALID_EMAIL_ADDRESS);

        } else if (mPhoneNumber.getText().toString().isEmpty()) {
            mCity.requestFocus();
            mCity.setError(Warning.BLANK_FIELD);


        } else {
            return true;
        }
        return false;


    }

    private void getIntilalData() {
        ProgressUtil.showProgressDialog(this);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiParams.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<SignUpData> call = apiService.getSignUpData(ApiParams.SINGUP_DATA_TAG);
        call.enqueue(new Callback<SignUpData>() {
            @Override
            public void onResponse(Call<SignUpData> call, Response<SignUpData> response) {

                Log.d("Response", response.body().getCountryList().get(0).getCTYNAME());
                if (response.body() != null) {
                    PrefUtil.putString(getApplication(), ApiParams.SINGUP_DATA, ApiParams.SINGUP_DATA, new Gson().toJson(response.body()));
                    fillData(response.body());
                }

                ProgressUtil.hideProgressDialog();
            }

            @Override
            public void onFailure(Call<SignUpData> call, Throwable t) {

                Log.d("Failure", t.getMessage());
                ProgressUtil.hideProgressDialog();

            }
        });

    }

    private void fillData(SignUpData response) {
        CountyAdapter mCountryAdapter = new CountyAdapter(SignUpActivity.this, response.getCountryList());
        LanguageAdapter languageAdapter = new LanguageAdapter(SignUpActivity.this, response.getLanguageList());
        UserTypeAdapter userTypeAdapter = new UserTypeAdapter(SignUpActivity.this, response.getUserTypeList());
        mCountry.setAdapter(mCountryAdapter);
        mLoginType.setAdapter(userTypeAdapter);
        mLanguage.setAdapter(languageAdapter);
    }


    @Override
    public void onClick(View view) {
        super.onClick(view);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        super.onCheckedChanged(compoundButton, b);
    }
}
