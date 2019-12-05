package com.example.bilibili.navigation.headpage.mainviews.shopping;

import androidx.lifecycle.ViewModelProviders;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.bilibili.R;
import com.example.bilibili.navigation.headpage.mainviews.shopping.TabPageFragmentAdapter.TabPageFragmentAdapter;
import com.example.bilibili.navigation.headpage.mainviews.shopping.fragment.CommodityFragment;
import com.example.bilibili.navigation.headpage.mainviews.shopping.fragment.InfomationFragment;
import com.example.bilibili.navigation.headpage.mainviews.shopping.fragment.PrettyPictureFragment;
import com.example.bilibili.navigation.headpage.mainviews.shopping.fragment.RecommandFragment;
import com.example.bilibili.utils.DensityUtil;
import com.google.android.material.tabs.TabLayout;
import com.lany.banner.BannerAdapter;
import com.lany.banner.BannerView;

import java.util.ArrayList;
import java.util.List;

public class ShoppingFragment extends Fragment {

    private ShoppingViewModel mViewModel;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private TextView textView;
    private BannerView bannerView;

    public static ShoppingFragment newInstance() {
        return new ShoppingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       return inflater.inflate(R.layout.shopping_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ShoppingViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tablayout_main);
        viewPager = view.findViewById(R.id.viewpager_items);
        bannerView = view.findViewById(R.id.banner_1);
        setItems();
        onBindData();
        tabLayout.setupWithViewPager(viewPager);
        init();
        Listener();
    }

    public void Listener(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_tablayout_text, null);
                TextView tv_tab = view.findViewById(R.id.text_tablayout);
                tv_tab.setTextSize(20);
                tv_tab.setTextColor(Color.BLACK);
                tv_tab.setText(tab.getText());
                tab.setCustomView(tv_tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setCustomView(null);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void onBindData(){
        String[] mTabNames=new String[]{"推荐","商品","美图","情报"};
        fragments = new ArrayList<>();
        fragments.add(new RecommandFragment(getActivity()));
        fragments.add(new CommodityFragment(getActivity()));
        fragments.add(new PrettyPictureFragment(getActivity()));
        fragments.add(new InfomationFragment(getActivity()));
        TabPageFragmentAdapter tabPageAdapter = new TabPageFragmentAdapter(getChildFragmentManager(),fragments,mTabNames);
        viewPager.setAdapter(tabPageAdapter);

    }
    public void init(){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_tablayout_text, null);
        textView = view.findViewById(R.id.text_tablayout);
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);
        textView.setText(tabLayout.getTabAt(0).getText());
        tabLayout.getTabAt(0).setCustomView(textView);
    }

    private List<String> bannerSourceItems;
    void setItems() {
        if(bannerSourceItems == null) {
            bannerSourceItems = new ArrayList<>();
        }
        RequestOptions myOptions =new RequestOptions()
                .transform((new MultiTransformation(new CenterCrop(), new RoundedCorners(DensityUtil.dip2px(getContext(),5)))));
        bannerSourceItems.clear();
        bannerSourceItems.add("http://i0.hdslb.com/bfs/archive/0e75efdfb8441fd424c3ef82e95e2c2ad7791c54.jpg");
        bannerSourceItems.add("http://i2.hdslb.com/bfs/archive/ac4ad60a441ad7d41c72d58a00f1bdd390ff9398.jpg");
        bannerSourceItems.add("http://i1.hdslb.com/bfs/archive/5e3af2630681e52a06d62ed7c8c7a7ccbc84c5d1.jpg");
        bannerSourceItems.add("http://i0.hdslb.com/bfs/archive/b7a65759d053fc3fd54a4fe51e3471917b969c07.jpg");
        setBannerImage(bannerView, myOptions);
    }

    void setBannerImage(BannerView view, RequestOptions options) {
        view.setAdapter(new BannerAdapter<String>(bannerSourceItems) {
            @Override
            public void bindImage(ImageView imageView, String item) {
                Glide.with(getContext()).load(item).error(R.drawable.ic_logo).apply(options).into(imageView);
            }

            @Override
            public void bindTitle(TextView titleText, String item) {

            }

            @Override
            public void onItemClicked(int position, String item) {

            }

        });
    }
}
