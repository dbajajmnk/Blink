package com.openxoft.blink.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.openxoft.blink.R;
import com.openxoft.blink.adapter.LanguageAdapter;
import com.openxoft.blink.listeners.CustomItemClickListener;
import com.openxoft.blink.model.LanguageList;

import java.util.ArrayList;
import java.util.List;

public class RecyclerBaseActivity extends AppCompatActivity implements CustomItemClickListener.OnItemSelectedListener {


    List<LanguageList>
    languageList;
    LanguageAdapter languageAdapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




    }
    private  void initView()
    {

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        languageList=new ArrayList<>();
      /*  languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));
        languageList.add(new Language("1","http://cdn.countryflags.com/thumbs/india/flag-round-250.png","English"));*/
       // languageAdapter=new LanguageAdapter(languageList,this);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
       // recyclerView.setAdapter(languageAdapter);
        recyclerView.addOnItemTouchListener(new CustomItemClickListener(this,this));
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
