package com.openxoft.blink;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.openxoft.blink.activities.LoginActivity;
import com.openxoft.blink.activities.SignUpActivity;
import com.openxoft.blink.api.ApiClient;
import com.openxoft.blink.api.ApiParams;
import com.openxoft.blink.api.ApiService;
import com.openxoft.blink.model.SignUpData;
import com.openxoft.blink.util.NetUtil;
import com.openxoft.blink.util.PrefUtil;
import com.openxoft.blink.util.ProgressUtil;
import com.openxoft.blink.util.Warning;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        if (PrefUtil.getString(MainActivity.this, ApiParams.SINGUP_DATA, ApiParams.SINGUP_DATA) != null) {


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (PrefUtil.getString(MainActivity.this, ApiParams.KEY_USEROBJECT, ApiParams.KEY_USEROBJECT)!=null) {
                        startActivity(new Intent(MainActivity.this, com.openxoft.blink.activities.MainActivity.class));
                    } else {
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    }

                }
            }, 5000);



        } else {
            if(NetUtil.isNetworkConnected(MainActivity.this))
            {
                getIntilalData();
            }
            else
            {
                Snackbar.make(null, Warning.NETWORK_PROBLEM,Snackbar.LENGTH_SHORT).setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getIntilalData();
                    }
                }).show();
            }

        }

    }
    private void getIntilalData() {


        ApiService apiService =  ApiClient.getApiClient();
        Call<SignUpData> call = apiService.getSignUpData(ApiParams.SINGUP_DATA_TAG);
        call.enqueue(new Callback<SignUpData>() {
            @Override
            public void onResponse(Call<SignUpData> call, Response<SignUpData> response) {

                Log.d("Response", response.body().getCountryList().get(0).getCTYNAME());
                if (response.body() != null) {
                    PrefUtil.putString(getApplication(), ApiParams.SINGUP_DATA, ApiParams.SINGUP_DATA, new Gson().toJson(response.body()));

                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }


            }

            @Override
            public void onFailure(Call<SignUpData> call, Throwable t) {


                ProgressUtil.hideProgressDialog();
                Snackbar.make(null, Warning.UNABLE_TO_LOAD_DATA,Snackbar.LENGTH_SHORT).setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getIntilalData();
                    }
                }).show();

            }
        });

    }
}
