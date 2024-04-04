package com.prithviraj.myportfolio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private ArrayList<String> mData;

    public MyAdapter(Context context, ArrayList<String> data) {
        super(context, R.layout.grid_item, data);
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.text_view);
        textView.setText(mData.get(position));

        return convertView;
    }
}

