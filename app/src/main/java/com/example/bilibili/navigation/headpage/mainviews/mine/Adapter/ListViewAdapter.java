package com.example.bilibili.navigation.headpage.mainviews.mine.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.bilibili.R;
import com.example.bilibili.navigation.headpage.mainviews.mine.Entity.Infor;

import java.io.File;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private List<Infor> inforList;
    private LayoutInflater inflater;

    public ListViewAdapter(List<Infor> inforList, Context context) {
        this.inforList = inforList;
        this.inflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return inforList == null?0:inforList.size();
    }

    @Override
    public Object getItem(int position) {
        return inforList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //加载布局为一个视图
        View view = inflater.inflate(R.layout.dropdown_style,null);
        Infor infor = (Infor) getItem(position);

        //在view 视图中查找 组件
        ImageView im_photo = view.findViewById(R.id.head_pic_id);
        TextView tv_name = view.findViewById(R.id.tv_nick);
        TextView tv_age = view.findViewById(R.id.tv_word);
        Button btn_follow=view.findViewById(R.id.btn_followyet);



        //为Item 里面的组件设置相应的数据
        tv_name.setText(infor.getNickname());
        tv_age.setText(infor.getWord());
        im_photo.setImageResource(infor.getHead_source());
//        im_photo.setImageDrawable(infor.getHead_source());
        btn_follow.setText(infor.getFollowyet());

        //返回含有数据的view
        return view;

    }
}
