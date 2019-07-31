package com.lexieluv.homeworkeleventh.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lexieluv.homeworkeleventh.R;
import com.lexieluv.homeworkeleventh.adapter.FindMainMenuAdapter;
import com.lexieluv.homeworkeleventh.adapter.FindSecondMenuAdapter;
import com.lexieluv.homeworkeleventh.adapter.ListViewAdapter;
import com.lexieluv.homeworkeleventh.adapter.MainHeaderAdAdapter;
import com.lexieluv.homeworkeleventh.adapter.MainMenuAdapter;
import com.lexieluv.homeworkeleventh.adapter.SecondMenuAdapter;
import com.lexieluv.homeworkeleventh.myListView;
import com.lexieluv.homeworkeleventh.util.DataUtil;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;


public class FindFragment extends Fragment {

    //创建listview中的集合
    private List<myListView> list = new ArrayList<>();

    //一级菜单图标
    protected  int [] menuIons={R.mipmap.find_main_travel
            ,R.mipmap.find_main_square
            ,R.mipmap.find_main_hotwind
            ,R.mipmap.find_main_way};

    //二级菜单图标
    protected int [] sMenuIcons = {R.mipmap.find_channel_parter
            ,R.mipmap.find_chnnel_me
            ,R.mipmap.find_channel_online};

    protected  String [] menus;
    protected String[] sMenus;
    protected RecyclerView mRecycleViewMenu;//主菜单
    protected RecyclerView sRecycleViewMenu;//二级菜单

    //定义进度条内容：百分比，图标点击，文字数量增加，进度条变化
    protected TextView tv_34,tv_66,left_like,right_like;
    protected ImageView left_btn,right_btn;
    protected ProgressBar pb_left,pb_right;

    public int a  = 51,b = 98;
    public double A = 0.34,B = 0.66;
    public NumberFormat nf = NumberFormat.getPercentInstance();

    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_find,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        menus=this.getActivity().getResources().getStringArray(R.array.find_main_menu);

        mRecycleViewMenu= (RecyclerView) getView().findViewById(R.id.find_main_channel);
        sRecycleViewMenu = getView().findViewById(R.id.find_channel_second);

        //菜单
        //布局样式
        mRecycleViewMenu.setLayoutManager(new GridLayoutManager(getActivity(),4));
        FindMainMenuAdapter mainMenuAdapter=new FindMainMenuAdapter(getActivity(),DataUtil.getMainMenus(menuIons,menus));
        mRecycleViewMenu.setAdapter(mainMenuAdapter);

        sMenus=this.getActivity().getResources().getStringArray(R.array.find_second_menu);
        sRecycleViewMenu.setLayoutManager(new GridLayoutManager(getActivity(),3));
        FindSecondMenuAdapter secondMenuAdapter = new FindSecondMenuAdapter(getActivity(),DataUtil.getSecondMenus(sMenuIcons,sMenus));
        sRecycleViewMenu.setAdapter(secondMenuAdapter);

        //热门头条的listview
        addingData();
        ListViewAdapter lva = new ListViewAdapter(getContext(),R.layout.listview_item ,list);
        ListView listView = getView().findViewById(R.id.list_hot_infos);
        listView.setAdapter(lva);

        //解决只显示一条数据的情况
        setListBaseForm(listView);

        //进度条相关处理
        tv_34 = getView().findViewById(R.id.txt_place_34);
        tv_66 = getView().findViewById(R.id.txt_place_66);
        left_like = getView().findViewById(R.id.left_like);
        right_like = getView().findViewById(R.id.right_like);

        left_btn = getView().findViewById(R.id.left_btn);
        right_btn = getView().findViewById(R.id.right_btn);
        ImageViewListener iv = new ImageViewListener();
        left_btn.setOnClickListener(iv);
        right_btn.setOnClickListener(iv);

        pb_left = getView().findViewById(R.id.pb_left);
        pb_right = getView().findViewById(R.id.pb_right);
        pb_left.setMax(100);
        pb_left.setProgress(66);
        pb_right.setMax(100);
        pb_right.setProgress(66);


        nf.setMaximumFractionDigits(0);//这个1的意识是保存结果到小数点后几位，但是特别声明：这个结果已经先＊100了。
        tv_34.setText(nf.format(A));
        tv_66.setText(nf.format(B));
    }
    //点击喜爱处理进度条，文字喜爱和上方百分比
    class ImageViewListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.left_btn:
                    //处理文字喜爱
                    a += 1;
                    left_like.setText(a+"人喜欢");
                    //处理百分比
                    A =(double)a/(double)(a+b);
                    tv_34.setText(nf.format(A));
                    Log.d("======34%======",nf.format(A));
                    //处理进度条
                    pb_left.setProgress((int) (100-A*100));
                    Log.d("======pbl======", String.valueOf((100-B*100)));
                    break;
                case R.id.right_btn:
                    //处理文字喜爱
                    b += 1;
                    right_like.setText(b+"人喜欢");
                    //处理百分比
                    B = (double)b/(double)(a+b);
                    tv_66.setText(nf.format(B));
                    Log.d("======66%======",nf.format(B));
                    //处理进度条
                    pb_right.setProgress((int) (B*100));
                    Log.d("======pbr======", String.valueOf((B*100)));
                    break;
            }
        }
    }

    private void setListBaseForm(ListView listView) {
        ListViewAdapter lva = (ListViewAdapter) listView.getAdapter();
        if(lva == null){
            return;
        }

        int Height = 0 ;
        for(int i = 0,len = lva.getCount();i < len;i++){
            View listItem = lva.getView(i,null,listView);
            listItem.measure(0,0);
            Height += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = Height + (listView.getDividerHeight() * (lva.getCount() - 1));
        listView.setLayoutParams(params);
    }

    private void addingData() {
        myListView one = new myListView("从广州去东莞仅需要半个小时，美食美景统统都在等着你！",
                "源自：羊城攻略",10326,21,R.mipmap.find_hot_city);
        list.add(one);
        myListView two = new myListView("旅行前最最应该做的10件准备事项，千万别给忽略了！",
                "源自：半日东跑",10002,15,R.mipmap.find_hot_home);
        list.add(two);
        myListView three = new myListView("北京周边竟然藏着20个绝美仙境，够你免费玩一年！",
                "源自：北京日报",895,0,R.mipmap.find_hot_jiangnan);
        list.add(three);
    }
}
