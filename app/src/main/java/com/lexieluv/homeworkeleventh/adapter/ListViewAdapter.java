package com.lexieluv.homeworkeleventh.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lexieluv.homeworkeleventh.R;
import com.lexieluv.homeworkeleventh.myListView;

import java.util.List;


public class ListViewAdapter extends ArrayAdapter {
    private final int itemID;

    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<myListView> objects) {
        super(context, resource, objects);
        itemID = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        myListView mlv = (myListView) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(itemID,parent,false);
        TextView title = view.findViewById(R.id.tv_hotTitle);
        TextView gonglue = view.findViewById(R.id.tv_gonglue);
        TextView look = view.findViewById(R.id.tv_look);
        TextView good = view.findViewById(R.id.tv_good);
        ImageView placeID = view.findViewById(R.id.iv_place);
        title.setText(mlv.getTitle());
        gonglue.setText(mlv.getGonglue());
        look.setInputType(mlv.getLook());
        good.setInputType(mlv.getGood());
        placeID.setImageResource(mlv.getPlaceID());
        return view;
    }

}
