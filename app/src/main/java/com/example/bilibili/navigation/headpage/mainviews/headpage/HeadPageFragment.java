package com.example.bilibili.navigation.headpage.mainviews.headpage;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.bilibili.MainActivity;
import com.example.bilibili.R;
import com.google.android.material.tabs.TabLayout;

public class HeadPageFragment extends Fragment {

    private HeadPageViewModel mViewModel;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView imageViewDownLoad;
    private ImageView imageViewMessage;

    public static HeadPageFragment newInstance() {
        return new HeadPageFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.head_page_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HeadPageViewModel.class);
        // TODO: Use the ViewModel

        init();

    }

    void init() {
        initMember();
        initClick();
        initViewPager();
    }

    private void initMember() {
        tabLayout = getView().findViewById(R.id.head_page_tabs);
        viewPager = getView().findViewById(R.id.head_page_view_pager);
        imageViewDownLoad = getView().findViewById(R.id.iv_download);
        imageViewMessage = getView().findViewById(R.id.iv_message);
    }

    void initClick() {
        LinearLayout layout = getView().findViewById(R.id.icon_group);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getDrawer().openDrawer(Gravity.LEFT);
            }
        });
        imageViewDownLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getContext();
                activity.getNavController().navigate(R.id.downloadFragment);
            }
        });
        imageViewMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getContext();
                activity.getNavController().navigate(R.id.messageFragment);
            }
        });

        /*
            此处设置TabLayout的导航栏选中效果
            需要自定义控件。注意控件多次生成的情况
         */
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initViewPager() {

        HeadViewPagerAdapter adapter = new HeadViewPagerAdapter(getChildFragmentManager(), getContext());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount());
        tabLayout.setupWithViewPager(viewPager);
    }

}