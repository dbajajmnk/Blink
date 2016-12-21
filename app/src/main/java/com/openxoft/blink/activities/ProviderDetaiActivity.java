package com.openxoft.blink.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.common.api.Api;
import com.openxoft.blink.R;
import com.openxoft.blink.adapter.ImageAdapter;
import com.openxoft.blink.api.ApiClient;
import com.openxoft.blink.api.ApiParams;
import com.openxoft.blink.api.ApiService;
import com.openxoft.blink.model.GalleryData;
import com.openxoft.blink.model.Service;
import com.openxoft.blink.util.ProgressUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ProviderDetaiActivity extends BaseActivity {

    TextView mTitle,mService,mCity,mPax,mDate,mPrice,mDescription;
    ImageView mImage;
    Button mGuest;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    List<String> mImages;
    ImageAdapter mImageAdapter;
    Service service;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_detail);
        initViews();


    }

    private void initViews() {
        mTitle=(TextView)findViewById(R.id.tv_title);
        mService=(TextView)findViewById(R.id.tv_service);
        mCity=(TextView)findViewById(R.id.tv_city);
        mPax=(TextView)findViewById(R.id.tv_pax);
        mDate=(TextView)findViewById(R.id.tv_date);
        mPrice=(TextView)findViewById(R.id.tv_price);
        mDescription=(TextView)findViewById(R.id.tv_description);
        mImage=(ImageView)findViewById(R.id.iv_main);
        mGuest=(Button)findViewById(R.id.bt_guestdetail);
        recyclerView=(RecyclerView)findViewById(R.id.images);
        mLayoutManager=new GridLayoutManager(this,4);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        mImages=new ArrayList<>();
        mImageAdapter=new ImageAdapter(this,mImages);
        recyclerView.setAdapter(mImageAdapter);
        mGuest.setOnClickListener(this);

        service=getIntent().getParcelableExtra(ApiParams.KEY_PROVIDERS);

        if(service!=null)
        {
            getServiceData();
            mTitle.setText(service.getServiceName().toUpperCase());
            mDescription.setText(Html.fromHtml(service.getDescriptionEnglish()));
            mPax.setText("Pax:"+"( "+service.getMinPax()+"-"+service.getMaxPax()+" )");
            mDate.setText("Date:"+service.getFromDate());
            mPrice.setText("$ "+service.getAmount());
            Glide.with(ProviderDetaiActivity.this).load(service.getImagePath()+"1.jpg").diskCacheStrategy(DiskCacheStrategy.ALL).into(mImage);
        }
    }

    private void getServiceData()
    {
        ProgressUtil.showProgressDialog(this);
        ApiService apiService= ApiClient.getApiClient();
        Log.d("Params",service.getServiceId()+"and TAG"+ApiParams.TAG_SERVICE_DATA);
        Call<GalleryData> call=apiService.getServiceData(ApiParams.TAG_SERVICE_DATA,service.getServiceId());
        call.enqueue(new Callback<GalleryData>() {
            @Override
            public void onResponse(Call<GalleryData> call, Response<GalleryData> response) {
                ProgressUtil.hideProgressDialog();
                for(int i=0;i<response.body().getData().size();i++)
                {
                    mImages.add(service.getImagePath()+response.body().getData().get(i)); Log.d("REsponse",response.body().getData().get(i));
                }
                mImageAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<GalleryData> call, Throwable t) {
                ProgressUtil.hideProgressDialog();
                Log.d("Failure",t.getMessage().toString());
            }
        });

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        startActivity(new Intent(this,GuestDetailFormActivity.class));
    }
}
