
package com.openxoft.blink.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.openxoft.blink.R;
import com.openxoft.blink.adapter.ProviderAdapter;
import com.openxoft.blink.api.ApiParams;
import com.openxoft.blink.listeners.CustomItemClickListener;
import com.openxoft.blink.model.Provider;
import com.openxoft.blink.model.Service;

import java.util.ArrayList;
import java.util.List;

public class ProviderActivity extends BaseActivity  {

    RecyclerView mProviders;
    ProviderAdapter mProviderAdapter;
    List<Provider>providerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);
        mProviders=(RecyclerView)findViewById(R.id.recyclerviewprovider);
        mProviders.setLayoutManager(new LinearLayoutManager(this));
        providerList=new ArrayList<>();
        List<Service>services=getIntent().getParcelableArrayListExtra(ApiParams.KEY_PROVIDERS);
        Log.d("Size of List",String.valueOf(services.size()));
        mProviderAdapter=new ProviderAdapter(services,this);
        mProviders.setAdapter(mProviderAdapter);




    }



}
