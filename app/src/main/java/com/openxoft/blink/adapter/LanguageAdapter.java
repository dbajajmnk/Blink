package com.openxoft.blink.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.openxoft.blink.R;
import com.openxoft.blink.model.LanguageList;

import java.util.List;

/**
 * Created by openxoft on 05/12/16.
 */

public class LanguageAdapter extends BaseAdapter {

    List<LanguageList>languageList;
    Context context;

    public LanguageAdapter(Context context, List<LanguageList>languageList)
    {
        this.languageList=languageList;
        this.context=context;
    }
    @Override
    public int getCount() {
        return languageList.size();
    }

    @Override
    public Object getItem(int i) {
        return languageList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LanguageList language=languageList.get(i);
        if (view==null)
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.county_item,viewGroup,false);
        }
        TextView name=(TextView)view.findViewById(R.id.tv_name);
        name.setText(language.getLNGLANGUAGE());

        return view;
    }
}
