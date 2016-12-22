package com.openxoft.blink.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.openxoft.blink.R;
import com.openxoft.blink.adapter.ViewPagerGalleryAdapter;
import com.openxoft.blink.api.ApiParams;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;

/**
 * Created by openxoft on 20/12/16.
 */

public class ImageGallery extends BaseActivity {

    ViewPager mGalleryImages;
    ArrayList<String> images;
    ViewPagerGalleryAdapter viewPagerGalleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        mGalleryImages=(ViewPager)findViewById(R.id.galleryview);
        if(getIntent().getExtras()!=null)
        {

            images=getIntent().getStringArrayListExtra(ApiParams.KEY_GALLERY_IMAGES);
            Log.d("Images Length",String.valueOf(images.size()));
            viewPagerGalleryAdapter=new ViewPagerGalleryAdapter(this,images);
            mGalleryImages.setAdapter(viewPagerGalleryAdapter);
            for(int i=0;i<images.size();i++)
            {
                Log.d("Image"+i,images.get(i));
            }
        }

    }
}
