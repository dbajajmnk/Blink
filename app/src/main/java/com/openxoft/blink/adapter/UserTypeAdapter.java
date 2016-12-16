package com.openxoft.blink.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.openxoft.blink.R;
import com.openxoft.blink.model.UserTypeList;

import java.util.List;

/**
 * Created by openxoft on 05/12/16.
 */

public class UserTypeAdapter extends BaseAdapter {

    List<UserTypeList>userTypeLists;
    Context context;

    public UserTypeAdapter(Context context, List<UserTypeList>userTypeLists)
    {
        this.userTypeLists=userTypeLists;
        this.context=context;
    }
    @Override
    public int getCount() {
        return userTypeLists.size();
    }

    @Override
    public Object getItem(int i) {
        return userTypeLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        UserTypeList countryList=userTypeLists.get(i);
        if (view==null)
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.county_item,viewGroup,false);
        }
        TextView name=(TextView)view.findViewById(R.id.tv_name);
        name.setText(countryList.getUSERTYPENAME());

        return view;
    }
}
