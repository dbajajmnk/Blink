package com.openxoft.blink.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.openxoft.blink.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by openxoft on 22/12/16.
 */

public class ViewPagerGalleryAdapter extends PagerAdapter {


    ArrayList<String> images;
    Context context;
    LayoutInflater layoutInflater;



    public  ViewPagerGalleryAdapter(Context context,ArrayList<String>images)
    {
        this.context=context;
        this.images=images;
        layoutInflater=LayoutInflater.from(context);
    }





    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {


        return view==((CardView)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View itemView=layoutInflater.inflate(R.layout.item_viewpager_image,container,false);
        ImageView imageView=(ImageView)itemView.findViewById(R.id.iconimage);
        Glide.with(context).load(images.get(position)).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((CardView)object);
    }
}
