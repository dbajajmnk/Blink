package com.openxoft.blink.listeners;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by openxoft on 18/11/16.
 */

public class CustomItemClickListener implements RecyclerView.OnItemTouchListener {


    GestureDetector gestureDetector;
    OnItemSelectedListener onItemSelectedListener;

    public CustomItemClickListener(Context context,OnItemSelectedListener onItemSelectedListener)
    {
        gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener()
        {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
        this.onItemSelectedListener=onItemSelectedListener;
    }




    public interface OnItemSelectedListener
    {
        void onItemClick(View view,int position);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View childView=rv.findChildViewUnder(e.getX(),e.getY());


        if(onItemSelectedListener!=null && gestureDetector.onTouchEvent(e) && childView!=null)
        {
            onItemSelectedListener.onItemClick(childView,rv.getChildAdapterPosition(childView));
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {


    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
