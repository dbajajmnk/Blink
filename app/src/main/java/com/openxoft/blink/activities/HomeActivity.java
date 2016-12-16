package com.openxoft.blink.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.openxoft.blink.R;

/**
 * Created by openxoft on 18/11/16.
 */

public class HomeActivity extends AppCompatActivity {

    DrawerLayout mDrawerlayout;
    ActionBarDrawerToggle mActionBarToogle;
    NavigationView mNavigationView;
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    private void initViews()
    {
        mDrawerlayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        mActionBarToogle=new ActionBarDrawerToggle(this,mDrawerlayout,mToolbar,R.string.opendrawer,R.string.closedrawer);
        mNavigationView=(NavigationView)findViewById(R.id.nav_view);

    }
}
