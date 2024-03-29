package com.lexieluv.homeworkeleventh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lexieluv.homeworkeleventh.R;
import com.lexieluv.homeworkeleventh.adapter.MainHeaderAdAdapter;
import com.lexieluv.homeworkeleventh.adapter.MainMenuAdapter;
import com.lexieluv.homeworkeleventh.adapter.SecondMenuAdapter;
import com.lexieluv.homeworkeleventh.util.DataUtil;

/**
 * 主界面视图
 */
public class MainFragment extends Fragment{

    protected  int [] icons={R.mipmap.header_pic_ad1,R.mipmap.header_pic_ad2,R.mipmap.header_pic_ad1};
    protected ViewPager mVPagerHeaderAd;//广告头

    //菜单图标
    protected  int [] menuIons={R.mipmap.menu_airport,R.mipmap.menu_car
             ,R.mipmap.menu_course,R.mipmap.menu_hatol,
            R.mipmap.menu_nearby,R.mipmap.me_menu_go,
            R.mipmap.menu_ticket,R.mipmap.menu_train};
    //二级菜单图标
    protected int [] sMenuIcons = {R.mipmap.menu_second_airport,R.mipmap.menu_second_play
    ,R.mipmap.menu_second_quan};

    protected  String [] menus;
    protected String[] sMenus;
    protected RecyclerView mRecycleViewMenu;//主菜单
    protected RecyclerView sRecycleViewMenu;//二级菜单
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        menus=this.getActivity().getResources().getStringArray(R.array.main_menu);

        mVPagerHeaderAd= (ViewPager) getView().findViewById(R.id.vpager_main_header_ad);
        mRecycleViewMenu= (RecyclerView) getView().findViewById(R.id.recycleview_main_menu);
        sRecycleViewMenu = getView().findViewById(R.id.recycleview_second_menu);

        MainHeaderAdAdapter adapter=new MainHeaderAdAdapter(getActivity(), DataUtil.getHeaderAddInfo(getActivity(),icons));
        mVPagerHeaderAd.setAdapter(adapter);

        //菜单
        //布局样式
        mRecycleViewMenu.setLayoutManager(new GridLayoutManager(getActivity(),4));
        MainMenuAdapter mainMenuAdapter=new MainMenuAdapter(getActivity(),DataUtil.getMainMenus(menuIons,menus));
        mRecycleViewMenu.setAdapter(mainMenuAdapter);

        sMenus=this.getActivity().getResources().getStringArray(R.array.main_second_menu);
        sRecycleViewMenu.setLayoutManager(new GridLayoutManager(getActivity(),3));
        SecondMenuAdapter secondMenuAdapter = new SecondMenuAdapter(getActivity(),DataUtil.getSecondMenus(sMenuIcons,sMenus));
        sRecycleViewMenu.setAdapter(secondMenuAdapter);
    }
}
