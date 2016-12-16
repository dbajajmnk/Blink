
package com.openxoft.blink.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.openxoft.blink.R;
import com.openxoft.blink.adapter.ProviderAdapter;
import com.openxoft.blink.listeners.CustomItemClickListener;
import com.openxoft.blink.model.Provider;

import java.util.ArrayList;
import java.util.List;

public class ProviderActivity extends BaseActivity implements CustomItemClickListener.OnItemSelectedListener {

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
        fillDatainList(providerList);
        mProviderAdapter=new ProviderAdapter(providerList,this);
        mProviders.setAdapter(mProviderAdapter);
        mProviders.addOnItemTouchListener(new CustomItemClickListener(this,this));

    }
    private void fillDatainList(List<Provider>languageList) {
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Provider("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
    }

    @Override
    public void onItemClick(View view, int position) {

        startActivity(new Intent(this,ProviderDetaiActivity.class));

    }
}
