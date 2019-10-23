package com.example.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.news.bean.MyItem;
import com.example.news.R;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<MyItem> {

    private int resourceId;

    public MyListAdapter(Context context, int textViewResourceId, List<MyItem> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyItem myItem=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView textView= view.findViewById(R.id.title);
        textView.setText(myItem.getTitle());
        return view;
    }
}
