package com.example.bilibili.activitys;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.bilibili.R;
import com.example.bilibili.contentobj.RecommendObject;
import com.example.bilibili.navigation.headpage.mainviews.videodetail.Fragment.BriefIntroFragment;
import com.example.bilibili.navigation.headpage.mainviews.videodetail.Fragment.CommentFragment;
import com.example.bilibili.navigation.headpage.mainviews.videodetail.TabFragmentPageAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class VideoDetailActivity extends AppCompatActivity {

    private final int MSG_HIDE = 0x01;
    private final int MSG_HIDEALL = 0x02;
    private final int TIME_OUT = 5000;
    private VideoView videoView;
    private FrameLayout frameLayoutVideo;
    private ImageView iv_video;
    private ImageView imageView_back;
    private LinearLayout linearLayout_top;
    private LinearLayout linearLayout_bottom;
    private ImageView beginOrEnd;
    private SeekBar seekBar;
    private ImageView imageView_quanping;
    private Handler handler;
    private Runnable hideRunable;
    private Runnable hideRunableAll;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private TextView tv_playTime;
    private NestedScrollView nestedScrollView;
    private Bundle data = new Bundle();
    private RecommendObject recommendObject;
    private BriefIntroFragment briefIntroFragment;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
        init();
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case MSG_HIDE:
                        if(linearLayout_bottom.isShown()){
                            linearLayout_bottom.setVisibility(View.GONE);
                        }
                        break;
                    case MSG_HIDEALL:
                        if (linearLayout_bottom.isShown() && linearLayout_top.isShown()){
                            linearLayout_bottom.setVisibility(View.GONE);
                            linearLayout_top.setVisibility(View.GONE);
                        }
                        break;
                }
            }
        };
        hideRunable = new Runnable() {
            @Override
            public void run() {
                handler.obtainMessage(MSG_HIDE).sendToTarget();
            }
        };
        hideRunableAll = new Runnable() {
            @Override
            public void run() {
                handler.obtainMessage(MSG_HIDEALL).sendToTarget();
            }
        };
        initTab();
        tabLayout.setupWithViewPager(viewPager);
        setListener();
    }
    public void init(){
        data = getIntent().getExtras();
        //videoView = findViewById(R.id.video);
        nestedScrollView = findViewById(R.id.nestedScroll);
        frameLayoutVideo = findViewById(R.id.video_fragment);
        imageView_back = findViewById(R.id.image_back);
        linearLayout_top = findViewById(R.id.line_top);
        linearLayout_bottom = findViewById(R.id.line_bottom);
        beginOrEnd = findViewById(R.id.image_beginOrEnd);
        seekBar = findViewById(R.id.seekBar);
        imageView_quanping = findViewById(R.id.image_quanping);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPage);
        iv_video = findViewById(R.id.video);
        tv_playTime = findViewById(R.id.tv_playtime);
        beginOrEnd.setTag("end");
        linearLayout_top.bringToFront();
        linearLayout_bottom.bringToFront();
        linearLayout_bottom.setVisibility(View.GONE);
        linearLayout_top.setVisibility(View.GONE);
        recommendObject = (RecommendObject) data.getSerializable("movie");
        Glide.with(this).load(recommendObject.pic).into(iv_video);
        tv_playTime.setText(recommendObject.duration);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setListener(){
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        frameLayoutVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beginOrEnd.getTag().equals("end")){
                    if(!linearLayout_bottom.isShown()){
                        linearLayout_bottom.setVisibility(View.VISIBLE);
                        linearLayout_top.setVisibility(View.VISIBLE);
                        handler.postDelayed(hideRunableAll,3000);
                    }else{
                        linearLayout_bottom.setVisibility(View.GONE);
                        linearLayout_top.setVisibility(View.GONE);
                        handler.removeCallbacks(hideRunableAll);
                    }
                }else{
                    if(!linearLayout_bottom.isShown()){
                        linearLayout_bottom.setVisibility(View.VISIBLE);
                        handler.postDelayed(hideRunable,3000);
                    }else{
                        linearLayout_bottom.setVisibility(View.GONE);
                        handler.removeCallbacks(hideRunable);
                    }
                }

            }
        });
        beginOrEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tag = (String) beginOrEnd.getTag();
                if(tag.equals("begin")){
                    handler.removeCallbacks(hideRunableAll);
                    handler.removeCallbacks(hideRunable);
                    beginOrEnd.setImageResource(R.drawable.ic_zanting);
                    beginOrEnd.setTag("end");
                    handler.postDelayed(hideRunableAll,3000);
                }else{
                    handler.removeCallbacks(hideRunableAll);
                    beginOrEnd.setImageResource(R.drawable.ic_bofang);
                    beginOrEnd.setTag("begin");
                    handler.postDelayed(hideRunable,3000);
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                handler.removeCallbacks(hideRunable);
                handler.removeCallbacks(hideRunableAll);
                if (beginOrEnd.getTag().equals("end")){
                    handler.postDelayed(hideRunableAll,3000);
                }else{
                    handler.postDelayed(hideRunable,3000);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                handler.removeCallbacks(hideRunable);
                handler.removeCallbacks(hideRunableAll);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(beginOrEnd.getTag().equals("end")){
                    handler.postDelayed(hideRunableAll,3000);
                }else{
                    handler.postDelayed(hideRunable,3000);
                }

            }
        });
        nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(scrollY >=10){

                }else{

                }
            }
        });
    }

    public void initTab(){
        String title = "评论" + recommendObject.review;
        String[] mTabNames=new String[]{"简介",title};
        fragmentList = new ArrayList<>();
        briefIntroFragment =  new BriefIntroFragment(VideoDetailActivity.this, recommendObject);
        fragmentList.add(briefIntroFragment);
        fragmentList.add(new CommentFragment(VideoDetailActivity.this));
        TabFragmentPageAdapter tabFragmentPageAdapter = new TabFragmentPageAdapter(getSupportFragmentManager(),fragmentList,mTabNames);
        viewPager.setAdapter(tabFragmentPageAdapter);
    }

}
