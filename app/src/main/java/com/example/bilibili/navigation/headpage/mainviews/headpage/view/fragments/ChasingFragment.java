package com.example.bilibili.navigation.headpage.mainviews.headpage.view.fragments;


import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.bilibili.R;
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters.ChaseRecycleShowOneAdapter;
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters.ChaseRecycleShowTwoAdapter;
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.fragments.chase.weekFragment.FragmentFriday;
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.fragments.chase.weekFragment.FragmentMonday;
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.fragments.chase.weekFragment.FragmentSaturday;
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.fragments.chase.weekFragment.FragmentSunday;
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.fragments.chase.weekFragment.FragmentThursday;
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.fragments.chase.weekFragment.FragmentTuesday;
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.fragments.chase.weekFragment.FragmentWednesday;
import com.example.bilibili.utils.DensityUtil;
import com.lany.banner.BannerAdapter;
import com.lany.banner.BannerView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChasingFragment extends Fragment {

    private BannerView bannerChasing;//轮播图
    private RecyclerView recyclerViewOne;
    private RecyclerView recyclerViewTwo;
    private Context context;
    List<Integer> imageList;


    private FragmentFriday fragmentFriday;
    private FragmentMonday fragmentMonday;
    private FragmentThursday fragmentThursday;
    private FragmentTuesday fragmentTuesday;
    private FragmentSaturday fragmentSaturday;
    private FragmentSunday fragmentSunday;
    private FragmentWednesday fragmentWednesday;


    private TextView tvWeek1;
    private TextView tvWeek2;
    private TextView tvWeek3;
    private TextView tvWeek4;
    private TextView tvWeek5;
    private TextView tvWeek6;
    private TextView tvWeek7;

    List<TextView> listTv;
    String[] weekStr={"一","二","三","四","五","六","日"
    };
    String[] weekOnclickStr={"周一","周二","周三","周四","周五","周六","周日"
    };



    public ChasingFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_chasing, container, false);
        return view;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        context=getContext();
        bannerChasing=view.findViewById(R.id.chasing_banner);
        recyclerViewOne=view.findViewById(R.id.chase_recycleView_1);
        recyclerViewTwo=view.findViewById(R.id.chase_recycleView_2);
        tvWeek1=view.findViewById(R.id.weekMenu).findViewById(R.id.week_tv_1);
        tvWeek2=view.findViewById(R.id.weekMenu).findViewById(R.id.week_tv_2);
        tvWeek3=view.findViewById(R.id.weekMenu).findViewById(R.id.week_tv_3);
        tvWeek4=view.findViewById(R.id.weekMenu).findViewById(R.id.week_tv_4);
        tvWeek5=view.findViewById(R.id.weekMenu).findViewById(R.id.week_tv_5);
        tvWeek6=view.findViewById(R.id.weekMenu).findViewById(R.id.week_tv_6);
        tvWeek7=view.findViewById(R.id.weekMenu).findViewById(R.id.week_tv_7);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewOne.setLayoutManager(linearLayoutManager);
        recyclerViewOne.setAdapter(new ChaseRecycleShowOneAdapter(context));
        recyclerViewOne.addItemDecoration(new mydecortion());


        LinearLayoutManager l2=new LinearLayoutManager(context);
        l2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewTwo.setLayoutManager(l2);
        recyclerViewTwo.setAdapter(new ChaseRecycleShowTwoAdapter(context));
        recyclerViewTwo.addItemDecoration(new mydecortion());

        initiWeekFragment();//初始化一周滑动
        loadBanner();//初始化轮播图
    }


    class Onclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.week_tv_1:
                    Log.d("sdasds", "onNavigationItemSelected: 544545");
                    if (fragmentMonday == null) {
                        fragmentMonday = new FragmentMonday(getContext());
                    }
                    getFragmentManager().beginTransaction().replace(R.id.chase_fragmentlayput, fragmentMonday)
                            .addToBackStack(null).commitAllowingStateLoss();//跳转fragment
                    changeOtherTvBackGround(tvWeek1);
                    break;
                case R.id.week_tv_2:
                    if (fragmentTuesday == null) {
                        fragmentTuesday = new FragmentTuesday(getContext());
                    }
                    getFragmentManager().beginTransaction().replace(R.id.chase_fragmentlayput, fragmentTuesday)
                            .addToBackStack(null).commitAllowingStateLoss();//
                    changeOtherTvBackGround(tvWeek2);
                    break;
                case R.id.week_tv_3:
                    if (fragmentWednesday == null) {
                        fragmentWednesday = new FragmentWednesday(getContext());
                    }
                    getFragmentManager().beginTransaction().replace(R.id.chase_fragmentlayput, fragmentWednesday)
                            .addToBackStack(null).commitAllowingStateLoss();//
                    changeOtherTvBackGround(tvWeek3);
                    break;
                case R.id.week_tv_4:
                    if (fragmentThursday == null) {
                        fragmentThursday = new FragmentThursday(getContext());
                    }
                    getFragmentManager().beginTransaction().replace(R.id.chase_fragmentlayput, fragmentThursday)
                            .addToBackStack(null).commitAllowingStateLoss();//
                    changeOtherTvBackGround(tvWeek4);
                    break;
                case R.id.week_tv_5:
                    if (fragmentFriday == null) {
                        fragmentFriday = new FragmentFriday(getContext());
                    }
                    getFragmentManager().beginTransaction().replace(R.id.chase_fragmentlayput, fragmentFriday)
                            .addToBackStack(null).commitAllowingStateLoss();//
                    changeOtherTvBackGround(tvWeek5);
                    break;
                case R.id.week_tv_6:
                    if (fragmentSaturday == null) {
                        fragmentSaturday = new FragmentSaturday(getContext());
                    }
                    getFragmentManager().beginTransaction().replace(R.id.chase_fragmentlayput, fragmentSaturday)
                            .addToBackStack(null).commitAllowingStateLoss();//
                    changeOtherTvBackGround(tvWeek6);
                    break;
                case R.id.week_tv_7:
                    if (fragmentSunday == null) {
                        fragmentSunday = new FragmentSunday(getContext());
                    }
                    getFragmentManager().beginTransaction().replace(R.id.chase_fragmentlayput, fragmentSunday)
                            .addToBackStack(null).commitAllowingStateLoss();//默认加载App布局
                    changeOtherTvBackGround(tvWeek7);
                    break;
                default:
            }
        }
    }

    void initiWeekFragment(){


        Onclick onclick=new Onclick();
        listTv=new ArrayList<>();
        listTv.add(tvWeek1);
        listTv.add(tvWeek2);
        listTv.add(tvWeek3);
        listTv.add(tvWeek4);
        listTv.add(tvWeek5);
        listTv.add(tvWeek6);
        listTv.add(tvWeek7);

        tvWeek1.setOnClickListener(onclick);
        tvWeek2.setOnClickListener(onclick);
        tvWeek3.setOnClickListener(onclick);
        tvWeek4.setOnClickListener(onclick);
        tvWeek5.setOnClickListener(onclick);
        tvWeek6.setOnClickListener(onclick);
        tvWeek7.setOnClickListener(onclick);
        fragmentMonday=new FragmentMonday(getContext());
        getFragmentManager().beginTransaction().add(R.id.chase_fragmentlayput,fragmentMonday).commitAllowingStateLoss();//默认加载App布局
        changeOtherTvBackGround(tvWeek1);

    }

    void changeOtherTvBackGround(TextView currentTextView){
        Drawable drawable=getResources().getDrawable(R.drawable.chase_weekbtbg);
        int i=0;
        for (TextView tv:listTv){
            if (currentTextView==tv){//点击tv改变背景和text
                currentTextView.setText(weekOnclickStr[i]);
                currentTextView.setBackgroundDrawable(drawable);
                i++;
                continue;
            }
            //没有点击
            tv.setText(weekStr[i]);
            tv.setBackgroundDrawable(null);
            i++;
        }
    }



    private void loadBanner(){

        if (imageList==null){
            imageList=new ArrayList<>();
        }
        imageList.add(R.mipmap.roundplay_1);
        imageList.add(R.mipmap.roundplay_2);
        imageList.add(R.mipmap.roundplay_3);
        RequestOptions myOptions =new RequestOptions()
                .transform((new MultiTransformation(new CenterCrop(), new RoundedCorners(DensityUtil.dip2px(context,10)))));
        bannerChasing.isAutoPlay(true);
        bannerChasing.setDelayTime(3000);
        setBannerImage(bannerChasing,myOptions);

    }

    void setBannerImage(BannerView view, RequestOptions options) {
        view.setAdapter(new BannerAdapter<Integer>(imageList) {
            @Override
            public void bindImage(ImageView imageView, Integer item) {
                Glide.with(context).load(item).error(R.drawable.ic_logo).apply(options).into(imageView);
            }

            @Override
            public void bindTitle(TextView titleText, Integer item) {

            }

            @Override
            public void onItemClicked(int position, Integer item) {

            }
        });
    }

    class mydecortion extends RecyclerView.ItemDecoration{

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap=getResources().getDimensionPixelOffset(R.dimen.search_show_box_padding_left);
            outRect.set(0,0,gap,0);
        }
    }





}
