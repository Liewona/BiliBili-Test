package com.example.bilibili.navigation.headpage.mainviews.videodetail;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabFragmentPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private String[] titleNames;

    public TabFragmentPageAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList, String[] titleNames) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleNames = titleNames;
    }


    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleNames[position];
    }

}
