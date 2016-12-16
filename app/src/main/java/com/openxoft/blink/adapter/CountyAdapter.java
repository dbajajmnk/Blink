package com.openxoft.blink.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.openxoft.blink.R;
import com.openxoft.blink.model.CountryList;

import java.util.List;

/**
 * Created by openxoft on 05/12/16.
 */

public class CountyAdapter extends BaseAdapter {

    List<CountryList>countryLists;
    Context context;

    public  CountyAdapter(Context context,List<CountryList>countryLists)
    {
        this.countryLists=countryLists;
        this.context=context;
    }
    @Override
    public int getCount() {
        return countryLists.size();
    }

    @Override
    public Object getItem(int i) {
        return countryLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CountryList countryList=countryLists.get(i);
        if (view==null)
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.county_item,viewGroup,false);
        }
        TextView name=(TextView)view.findViewById(R.id.tv_name);
        name.setText(countryList.getCTYNAME());

        return view;
    }
}
