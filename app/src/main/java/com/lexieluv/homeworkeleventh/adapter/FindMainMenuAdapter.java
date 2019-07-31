package com.lexieluv.homeworkeleventh.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lexieluv.homeworkeleventh.R;
import com.lexieluv.homeworkeleventh.entity.Menu;

import java.util.List;

public class FindMainMenuAdapter extends RecyclerView.Adapter<FindMainMenuViewholder> {
    protected Context context;
    protected List<Menu> menus;

    public FindMainMenuAdapter(Context context, List<Menu> menus) {
        this.context = context;
        this.menus = menus;
    }

    @Override
    public FindMainMenuViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FindMainMenuViewholder(LayoutInflater.from(context).inflate(R.layout.fragment_find, null));
    }

    @Override
    public void onBindViewHolder(FindMainMenuViewholder holder, int position) {
        Menu menu = menus.get(position);
        holder.fImgMenuIcon.setImageResource(menu.icon);
        holder.fTxtMenuName.setText(menu.menuName);
    }

    @Override
    public int getItemCount() {
        return null != menus ? menus.size() : 0;
    }
}

    class FindMainMenuViewholder extends RecyclerView.ViewHolder {

        public ImageView fImgMenuIcon;
        public TextView fTxtMenuName;

        public FindMainMenuViewholder(View itemView) {
            super(itemView);
            fImgMenuIcon = (ImageView) itemView.findViewById(R.id.img_find_menu_icon);
            fTxtMenuName = (TextView) itemView.findViewById(R.id.txt_find_menu_name);
    }
}
