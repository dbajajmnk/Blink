package com.openxoft.blink.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.openxoft.blink.R;

import java.util.List;

/**
 * Created by openxoft on 21/12/16.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {


    Context context;
    List<String>images;

    public ImageAdapter(Context context, List<String>images)
    {
        this.context=context;
        this.images=images;
    }




    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.item_image_icon,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

        ImageViewHolder imageViewHolder=holder;
        Glide.with(context).load(images.get(position)).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imageView;
        public ImageViewHolder(View itemView) {


            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.iconimage);

        }
    }
}
