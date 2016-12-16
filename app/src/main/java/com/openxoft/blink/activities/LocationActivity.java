package com.openxoft.blink.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.openxoft.blink.R;
import com.openxoft.blink.adapter.LanguageAdapter;
import com.openxoft.blink.listeners.CustomItemClickListener;
import com.openxoft.blink.model.LanguageList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by openxoft on 18/11/16.
 */
public class LocationActivity extends AppCompatActivity implements CustomItemClickListener.OnItemSelectedListener{



    List<LanguageList> languageList;
    LanguageAdapter languageAdapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initView();

    }
    private  void initView()
    {

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        languageList=new ArrayList<>();
        fillDatainList(languageList);
       /* languageAdapter=new LanguageAdapter(languageList,this);*/
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
      /*  recyclerView.setAdapter(languageAdapter);*/
        recyclerView.addOnItemTouchListener(new CustomItemClickListener(this,this));
    }

    private void fillDatainList(List<LanguageList>languageList) {

    }

    @Override
    public void onItemClick(View view, int position) {

        startActivity(new Intent(this,LoginActivity.class));


    }
}
