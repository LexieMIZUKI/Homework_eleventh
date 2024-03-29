package com.lexieluv.homeworkeleventh.util;

import android.content.Context;
import android.widget.ImageView;

import com.lexieluv.homeworkeleventh.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/7.
 */
public class DataUtil {

    /**
     *
     * @param context
     * @param icons
     * @return
     */
    public static List<ImageView> getHeaderAddInfo(Context context,int icons[]){
        List<ImageView>  datas=new ArrayList<>();
        for (int i = 0; i <icons.length ; i++) {
            ImageView  icon=new ImageView(context);
            icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
            icon.setImageResource(icons[i]);
            datas.add(icon);
        }
        return datas;
    }


    /**
     * 主菜单
     * @param icons
     * @param names
     * @return
     */
    public static List<Menu>  getMainMenus(int icons[],String names[]){
        List<Menu>  menus=new ArrayList<>();

        for (int i = 0; i <icons.length ; i++) {
            Menu menu=new Menu(icons[i],names[i]);
            menus.add(menu);
        }
        return menus;
    }

    /**
     * 二级菜单
     * @param sIcons
     * @param sNames
     * @return
     */

    public static List<Menu> getSecondMenus(int sIcons[],String sNames[]){
        List<Menu> menus = new ArrayList<>();

        for(int i = 0;i < sIcons.length; i++){
            Menu menu = new Menu(sIcons[i],sNames[i]);
            menus.add(menu);
        }
        return menus;
    }
}
