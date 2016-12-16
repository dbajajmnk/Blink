package com.openxoft.blink.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.android.gms.common.api.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.openxoft.blink.R;
import com.openxoft.blink.api.ApiParams;
import com.openxoft.blink.api.ApiService;
import com.openxoft.blink.api.AppController;
import com.openxoft.blink.api.CustomRequest;
import com.openxoft.blink.model.LanguageList;
import com.openxoft.blink.model.LoginDetail;
import com.openxoft.blink.model.SignUpData;
import com.openxoft.blink.model.User;
import com.openxoft.blink.util.LocaleHelper;
import com.openxoft.blink.util.NetUtil;
import com.openxoft.blink.util.PrefUtil;
import com.openxoft.blink.util.ProgressUtil;
import com.openxoft.blink.util.Warning;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by openxoft on 18/11/16.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mForgot, mSignUp, mContinue;
    Button mLogin;
    EditText mUserName, mPassword;

    ImageView mLanguage1,mLanguage2,mLanguage3,mLanguage4;
    List<LanguageList> activeLanguages;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logins);
        initViews();
    }

    private void initViews() {
        activeLanguages=new ArrayList<>();
        mForgot = (TextView) findViewById(R.id.tv_forgot);
        mSignUp = (TextView) findViewById(R.id.tv_signup);
        mContinue = (TextView) findViewById(R.id.tv_continuewithoutlogin);
        mLogin = (Button) findViewById(R.id.bt_login);
        mUserName = (EditText) findViewById(R.id.et_name);
        mPassword = (EditText) findViewById(R.id.et_password);
        mLanguage1=(ImageView) findViewById(R.id.language1);
        mLanguage2=(ImageView) findViewById(R.id.language2);
        mLanguage3=(ImageView) findViewById(R.id.language3);
        mLanguage4=(ImageView) findViewById(R.id.language4);
        mLanguage1.setOnClickListener(this);
        mLanguage2.setOnClickListener(this);
        mLanguage3.setOnClickListener(this);
        mLanguage4.setOnClickListener(this);

        String data=PrefUtil.getString(getApplicationContext(),ApiParams.SINGUP_DATA,ApiParams.SINGUP_DATA);
        Log.d("Data",data);
      SignUpData signUpData = new Gson().fromJson(data, SignUpData.class);
     Log.d("SignUpData",signUpData.getCountryList().get(0).getCTYNAME());
        if(signUpData!=null) {
            for (int i = 0; i < signUpData.getLanguageList().size(); i++) {
                if (signUpData.getLanguageList().get(i).getLNGACTIVE()) {
                    activeLanguages.add(signUpData.getLanguageList().get(i));
                }
            }
            for (int i = 0; i < activeLanguages.size(); i++) {

                switch (i) {
                    case 0:
                        useImageWithImageView(activeLanguages.get(i).getLNGFLAG(), mLanguage1);
                        break;
                    case 1:
                        useImageWithImageView(activeLanguages.get(i).getLNGFLAG(), mLanguage2);
                        break;
                    case 2:
                        useImageWithImageView(activeLanguages.get(i).getLNGFLAG(), mLanguage3);
                        break;
                    case 3:
                        useImageWithImageView(activeLanguages.get(i).getLNGFLAG(), mLanguage4);
                        break;
                }
            }
        }

        mLogin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String lenguage=null;
        switch (view.getId()) {
            case R.id.bt_login:
                if (validateInput()) {
                    if (NetUtil.isNetworkConnected(this)) {
                        if (validateInput()) {

                            loginCall(mUserName.getText().toString(), mPassword.getText().toString());

                        }
                    } else {
                        Snackbar.make(view, Warning.NETWORK_PROBLEM, Snackbar.LENGTH_SHORT).show();
                    }
                }

                break;
            case R.id.language1:
                lenguage="en";
                Log.d("Click","I am Clicked");
                break;
            case R.id.language2:
                lenguage="fr";
                Log.d("Click","I am Clicked");
                break;
            case R.id.language3:
                lenguage="it";
                Log.d("Click","I am Clicked");
                break;
            case R.id.language4:
                lenguage="es";
                Log.d("Click","I am Clicked");
                break;
        }
        if(lenguage!=null) {
            PrefUtil.putString(getApplicationContext(), ApiParams.KEY_LANGUAGE, ApiParams.KEY_LANGUAGE, lenguage);
            LocaleHelper.setLocale(getApplicationContext(),lenguage);
        }
    }

    private boolean validateInput() {
        if (mUserName.getText().toString().isEmpty()) {
            mUserName.requestFocus();
            mUserName.setError(Warning.BLANK_FIELD);

        } else if (mPassword.getText().toString().isEmpty()) {
            mPassword.requestFocus();
            mPassword.setError(Warning.BLANK_FIELD);
        } else {
            return true;
        }
        return false;
    }
    private void useImageWithImageView(String url,ImageView mLanguage1)
    {
        Glide.with(getApplicationContext()).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(mLanguage1);
    }

    private void loginCall(String username, String password) {

        ProgressUtil.showProgressDialog(this);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiParams.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<LoginDetail> call = apiService.getUserFromLogin(username, password,ApiParams.LOGIN_TAG);
        call.enqueue(new Callback<LoginDetail>() {
            @Override
            public void onResponse(Call<LoginDetail> call, Response<LoginDetail> response) {
                ProgressUtil.hideProgressDialog();
                if (response != null) {
                    LoginDetail loginDetail = response.body();
                    if (loginDetail.getResponse().equals("Sucess")) {
                        Gson gson = new GsonBuilder().create();
                        PrefUtil.putString(LoginActivity.this, ApiParams.KEY_USEROBJECT, ApiParams.KEY_USEROBJECT, gson.toJson(response.body()));
                        PrefUtil.putString(LoginActivity.this,ApiParams.KEY_USER_PASSWORD,ApiParams.KEY_USER_PASSWORD,mPassword.getText().toString());
                        PrefUtil.putString(LoginActivity.this,ApiParams.KEY_USER_NAME,ApiParams.KEY_USER_NAME,mUserName.getText().toString());
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));

                    } else {
                        Toast.makeText(LoginActivity.this,loginDetail.getResponse(),Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Snackbar.make(mLanguage1,Warning.NoData,Snackbar.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginDetail> call, Throwable t) {

                Snackbar.make(mLanguage1, Warning.SORRY_SERVER_MESSAGE, Snackbar.LENGTH_SHORT).show();
                ProgressUtil.hideProgressDialog();

            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public void callSignUp(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }

    public void callForgot(View view) {
        startActivity(new Intent(this, ForgotActivity.class));
    }

    public void callHome(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }





}
