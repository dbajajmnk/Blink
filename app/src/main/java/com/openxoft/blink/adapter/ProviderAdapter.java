package com.openxoft.blink.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.openxoft.blink.R;
import com.openxoft.blink.model.Provider;

import java.util.List;

/**
 * Created by openxoft on 18/11/16.
 */

public class ProviderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    List<Provider>languages;
    Context context;

    public ProviderAdapter(List<Provider> languages, Context context) {
        this.languages = languages;
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
        Provider language=languages.get(position);
        languageViewHolder.name.setText(language.getName());
        Glide.with(context).load(language.getImage()).diskCacheStrategy(DiskCacheStrategy.ALL).into(languageViewHolder.imageView);

    }



    @Override
    public int getItemCount() {
        return languages.size();
    }

    static public class LanguageViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView imageView;
        public LanguageViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.tv_languagename);
            imageView=(ImageView)itemView.findViewById(R.id.iv_lanuageion);
        }
    }
}
