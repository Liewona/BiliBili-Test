package com.example.bilibili.navigation.headpage.mainviews.channel;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bilibili.R;
import com.example.bilibili.laiyu.LoginActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class ChannelFragment extends Fragment {

    private int flag=0;

    private ChannelViewModel mViewModel;

    public static ChannelFragment newInstance() {
        return new ChannelFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        String[] name=new  String[]{
                "番剧","国创","放映厅","纪录片",
                "漫画","专栏","直播","课堂",
                "动画","音乐","舞蹈","游戏",
                "科技","数码","生活","VLOG",
                "鬼畜","时尚","广告","娱乐",
                "影视","电影","电视剧","小视频",
                "相簿","会员购","话题中心","全区排行榜",
                "活动中心","小黑屋","游戏中心","游戏赛事",
                "音频"
        };

        int[] image=new int[]{
                R.drawable.ic_category_1, R.drawable.ic_category_2, R.drawable.ic_category_3, R.drawable.ic_category_4,
                R.drawable.ic_category_5, R.drawable.ic_category_6, R.drawable.ic_category_7, R.drawable.ic_category_8,
                R.drawable.ic_category_9, R.drawable.ic_category_10, R.drawable.ic_category_11, R.drawable.ic_category_12,
                R.drawable.ic_category_13, R.drawable.ic_category_14, R.drawable.ic_category_15, R.drawable.ic_category_16,
                R.drawable.ic_category_17, R.drawable.ic_category_18, R.drawable.ic_category_19, R.drawable.ic_category_20,
                R.drawable.ic_category_21, R.drawable.ic_category_22, R.drawable.ic_category_23, R.drawable.ic_category_24,
                R.drawable.ic_category_25, R.drawable.ic_category_26, R.drawable.ic_category_27, R.drawable.ic_category_28,
                R.drawable.ic_category_29, R.drawable.ic_category_30, R.drawable.ic_category_31, R.drawable.ic_category_32,
                R.drawable.ic_category_33
        };


        View view =inflater.inflate(R.layout.channel_fragment, container, false);
        View viewChild =inflater.inflate(R.layout.all_channel, container, false);
        ((LinearLayout)view.findViewById(R.id.all_channel)).addView(viewChild);


        for (int i=0;i<8;i++){

                View viewChild1 = inflater.inflate(R.layout.all_partition, container, false);
                ((ImageView) viewChild1.findViewById(R.id.all_partition_iv1)).setImageDrawable(getResources().getDrawable(image[i*4]));
                ((TextView) viewChild1.findViewById(R.id.all_partition_tv1)).setText(name[i * 4 ]);
                ((ImageView) viewChild1.findViewById(R.id.all_partition_iv2)).setImageDrawable(getResources().getDrawable(image[i*4+1]));
                ((TextView) viewChild1.findViewById(R.id.all_partition_tv2)).setText(name[i*4+1]);
                ((ImageView) viewChild1.findViewById(R.id.all_partition_iv3)).setImageDrawable(getResources().getDrawable(image[i*4+2]));
                ((TextView) viewChild1.findViewById(R.id.all_partition_tv3)).setText(name[i*4+2]);
                ((ImageView) viewChild1.findViewById(R.id.all_partition_iv4)).setImageDrawable(getResources().getDrawable(image[i*4+3]));
                ((TextView) viewChild1.findViewById(R.id.all_partition_tv4)).setText(name[i*4+3]);

                ((LinearLayout) view.findViewById(R.id.channelFragment_blocks)).addView(viewChild1);

        }

        View viewChild1 = inflater.inflate(R.layout.all_partition, container, false);
        ((ImageView) viewChild1.findViewById(R.id.all_partition_iv1)).setImageDrawable(getResources().getDrawable(image[32]));
        ((TextView) viewChild1.findViewById(R.id.all_partition_tv1)).setText(name[32]);
        ((ImageView) viewChild1.findViewById(R.id.all_partition_iv2)).setVisibility(View.INVISIBLE);
        ((TextView) viewChild1.findViewById(R.id.all_partition_tv2)).setVisibility(View.INVISIBLE);
        ((ImageView) viewChild1.findViewById(R.id.all_partition_iv3)).setVisibility(View.INVISIBLE);
        ((TextView) viewChild1.findViewById(R.id.all_partition_tv3)).setVisibility(View.INVISIBLE);
        ((ImageView) viewChild1.findViewById(R.id.all_partition_iv4)).setVisibility(View.INVISIBLE);
        ((TextView) viewChild1.findViewById(R.id.all_partition_tv4)).setVisibility(View.INVISIBLE);

        ((LinearLayout) view.findViewById(R.id.channelFragment_blocks)).addView(viewChild1);


        view.findViewById(R.id.channelFragment_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==0) {
                    flag=1;
                    ((TextView) view.findViewById(R.id.channelFragment_close)).setText("展开分区");
                    ((LinearLayout) view.findViewById(R.id.channelFragment_blocks)).setVisibility(View.GONE);
                }
                else {
                    ((TextView) view.findViewById(R.id.channelFragment_close)).setText("收起分区");
                    ((LinearLayout) view.findViewById(R.id.channelFragment_blocks)).setVisibility(View.VISIBLE);
                    flag=0;
                }
            }

        });

        view.findViewById(R.id.channelFragment_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ChannelViewModel.class);
        // TODO: Use the ViewModel
    }


//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
////        super.onSaveInstanceState(outState);
//    }
}
