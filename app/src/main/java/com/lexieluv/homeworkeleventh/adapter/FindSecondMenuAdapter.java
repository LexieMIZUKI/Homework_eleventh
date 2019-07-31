package com.lexieluv.homeworkeleventh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lexieluv.homeworkeleventh.R;
import com.lexieluv.homeworkeleventh.entity.Menu;

import java.util.List;

public class FindSecondMenuAdapter extends RecyclerView.Adapter<FindSecondMenuViewholder> {
    protected Context context;
    protected List<Menu> menus;

    public FindSecondMenuAdapter(Context context, List<Menu> menus){
        this.context=context;
        this.menus=menus;
    }
    @Override
    public FindSecondMenuViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FindSecondMenuViewholder(LayoutInflater.from(context).inflate(R.layout.fragment_find2,null));
    }

    @Override
    public void onBindViewHolder(FindSecondMenuViewholder holder, int position) {
        Menu menu=menus.get(position);
        holder.fsImgMenuIcon.setImageResource(menu.icon);
        holder.fsTxtMenuName.setText(menu.menuName);
    }

    @Override
    public int getItemCount() {
        return null!=menus?menus.size():0;
    }
}
    class  FindSecondMenuViewholder extends RecyclerView.ViewHolder{

        public ImageView fsImgMenuIcon;
        public TextView fsTxtMenuName;
        public FindSecondMenuViewholder(View itemView) {
            super(itemView);
            fsImgMenuIcon= itemView.findViewById(R.id.img_find_second_menu_icon);
            fsTxtMenuName= itemView.findViewById(R.id.txt_find_second_menu_name);
        }
}
