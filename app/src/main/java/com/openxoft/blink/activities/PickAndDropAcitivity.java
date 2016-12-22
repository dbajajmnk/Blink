package com.openxoft.blink.activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.datetimepicker.date.DatePickerDialog;
import com.android.datetimepicker.time.RadialPickerLayout;
import com.android.datetimepicker.time.TimePickerDialog;
import com.openxoft.blink.R;
import com.openxoft.blink.api.ApiClient;
import com.openxoft.blink.api.ApiParams;
import com.openxoft.blink.api.ApiService;
import com.openxoft.blink.model.AirPort;
import com.openxoft.blink.model.Airline;
import com.openxoft.blink.model.CheckOutForm;
import com.openxoft.blink.model.Service;
import com.openxoft.blink.util.DateUtil;
import com.openxoft.blink.util.ProgressUtil;
import com.openxoft.blink.util.Warning;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by openxoft on 22/12/16.
 */

public class PickAndDropAcitivity extends BaseActivity implements View.OnClickListener, android.app.TimePickerDialog.OnTimeSetListener{



    Spinner airplan,airlines;
    TextView mTiming;
    EditText mFlightNumber;
    private Service service;
    Calendar calendar=Calendar.getInstance();
    private List<String>airPortnames;
    private List<String>airlinesNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickanddropoff);
        initViews();

    }
    private void initViews()
    {
        service=getIntent().getParcelableExtra(ApiParams.KEY_PROVIDERS);
        airlines=(Spinner)findViewById(R.id.sp_airlines);
        airplan=(Spinner)findViewById(R.id.sp_airport);
        mTiming=(TextView)findViewById(R.id.tv_timing);
        mTiming.setOnClickListener(this);
        mFlightNumber=(EditText)findViewById(R.id.et_flightno);
        airPortnames=new ArrayList<>();
        airlinesNames=new ArrayList<>();

        getFormData();
    }

    private void getFormData()
    {
        ProgressUtil.showProgressDialog(this);
        ApiService apiService= ApiClient.getApiClient();
        Call<CheckOutForm>call=apiService.getServiceData(ApiParams.TAG_SERVICE_DATA,service.getServiceId());
        call.enqueue(new Callback<CheckOutForm>() {
            @Override
            public void onResponse(Call<CheckOutForm> call, Response<CheckOutForm> response) {
                ProgressUtil.hideProgressDialog();
                if(airlinesNames.size()>0 )
                {
                    airlinesNames.clear();

                }
                if(airPortnames.size()>0)
                {
                    airPortnames.clear();
                }
                airlinesNames.add(Warning.KEY_SELECT_AIRLINE);
                airPortnames.add(Warning.KEY_SELECT_AIRPORT);
                if(response.body().getCode().equalsIgnoreCase("1"))
                {
                    Log.d("Data",response.body().getData().getAirlineData().get(0).getALNAME());
                    for(int i=0;i<response.body().getData().getAirlineData().size();i++)
                    {
                        airlinesNames.add(response.body().getData().getAirlineData().get(i).getALNAME());
                    }
                    for(int i=0;i<response.body().getData().getAirPortData().size();i++)
                    {
                        airPortnames.add(response.body().getData().getAirPortData().get(i).getAIRPORTCODE());
                    }
                    airlines.setAdapter(new ArrayAdapter<String>(PickAndDropAcitivity.this,R.layout.support_simple_spinner_dropdown_item,airlinesNames));
                    airplan.setAdapter(new ArrayAdapter<String>(PickAndDropAcitivity.this,R.layout.support_simple_spinner_dropdown_item,airPortnames));


                }
                else
                {
                    Toast.makeText(getApplicationContext(),response.body().getResponse(),Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<CheckOutForm> call, Throwable t) {

                ProgressUtil.hideProgressDialog();
                Log.d("Failure",t.getMessage());

            }
        });
    }



    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId())
        {
            case R.id.tv_timing:

               TimePicker timePicker=new TimePicker(this);
               timePicker.setIs24HourView(true);
                timePicker.setEnabled(true);


                break;

        }
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

    }
}
