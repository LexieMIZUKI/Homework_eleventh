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

public class SecondMenuAdapter extends RecyclerView.Adapter<SecondMenuViewholder> {
    protected Context context;
    protected  List<Menu> menus;
    public SecondMenuAdapter(Context context, List<Menu> menus){
        this.context=context;
        this.menus=menus;
    }
    @Override
    public SecondMenuViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SecondMenuViewholder(LayoutInflater.from(context).inflate(R.layout.item_main_second_menu,null));
    }

    @Override
    public void onBindViewHolder(SecondMenuViewholder holder, int position) {

        Menu menu=menus.get(position);
        holder.sImgMenuIcon.setImageResource(menu.icon);
        holder.sTxtMenuName.setText(menu.menuName);
    }

    @Override
    public int getItemCount() {
        return null!=menus?menus.size():0;
    }
}
    class  SecondMenuViewholder extends RecyclerView.ViewHolder{

        public ImageView sImgMenuIcon;
        public TextView sTxtMenuName;
        public SecondMenuViewholder(View itemView) {
            super(itemView);
            sImgMenuIcon= itemView.findViewById(R.id.img_second_menu_icon);
            sTxtMenuName= itemView.findViewById(R.id.txt_second_menu_name);
        }
}
