package com.openxoft.blink.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

import com.openxoft.blink.R;


public class AboutUsActivity extends BaseActivity {

    TextView mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        mContent=(TextView)findViewById(R.id.tv_content);
        mContent.setMovementMethod(new ScrollingMovementMethod());

    }


}
