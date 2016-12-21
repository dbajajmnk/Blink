package com.openxoft.blink.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.openxoft.blink.R;
import com.openxoft.blink.activities.ProviderDetaiActivity;
import com.openxoft.blink.api.ApiParams;
import com.openxoft.blink.model.Provider;
import com.openxoft.blink.model.Service;

import java.io.File;
import java.util.List;

/**
 * Created by openxoft on 18/11/16.
 */

public class ProviderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{


    List<Service>serviceList;
    Context context;
    Service service=null;
    public ProviderAdapter(List<Service> languages, Context context) {
        this.serviceList = languages;
        this.context = context;
    }

    @Override
    public LanguageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.provider_item,parent,false);
        return new LanguageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LanguageViewHolder languageViewHolder= (LanguageViewHolder) holder;
        service=serviceList.get(position);
        languageViewHolder.name.setText(service.getServiceName().toUpperCase());
        Glide.with(context).load(service.getImagePath()).diskCacheStrategy(DiskCacheStrategy.ALL).into(languageViewHolder.imageView);
        languageViewHolder.pax.setText("Pax: "+"("+service.getMinPax()+"-"+service.getMaxPax()+")");



        languageViewHolder.type.setText("Type: "+"("+service.getPriceType()+")");
        languageViewHolder.price.setText("$"+service.getAmount());
        languageViewHolder.viewdetail.setText(R.string.viewdetail);
        languageViewHolder.price.setOnClickListener(this);
        languageViewHolder.viewdetail.setOnClickListener(this);


    }



    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    @Override
    public void onClick(View view) {
        Intent intent=null;

        switch (view.getId())
        {
            case R.id.tv_detail:
                intent=new Intent(context, ProviderDetaiActivity.class);
                intent.putExtra(ApiParams.KEY_PROVIDERS,service);
                break;
            case R.id.tv_price:

                break;
        }
        if(intent!=null)
        {
            context.startActivity(intent);
        }

    }

    static public class LanguageViewHolder extends RecyclerView.ViewHolder {

        TextView name,price,pax,type,viewdetail;
        ImageView imageView;
        public LanguageViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.tv_name);
            price=(TextView)itemView.findViewById(R.id.tv_price);
            pax=(TextView)itemView.findViewById(R.id.tv_pax);
            type=(TextView)itemView.findViewById(R.id.tv_type);
            viewdetail=(TextView)itemView.findViewById(R.id.tv_detail);
            imageView=(ImageView)itemView.findViewById(R.id.iv_serviceicon);
        }
    }
}
