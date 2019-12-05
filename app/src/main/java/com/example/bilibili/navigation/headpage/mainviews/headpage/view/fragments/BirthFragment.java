package com.example.bilibili.navigation.headpage.mainviews.headpage.view.fragments;


import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
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
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters.BirthAdapter;
import com.example.bilibili.utils.DensityUtil;
import com.lany.banner.BannerAdapter;
import com.lany.banner.BannerView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BirthFragment extends Fragment {
    private BannerView bannerView;
    private RecyclerView recyclerView;


    public BirthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_birth, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        bannerView = view.findViewById(R.id.birth_bannerView);
        recyclerView = view.findViewById(R.id.birth_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()){
            /**
             * 重写该方法使RecyclerView不能滑动
             * @return false
             */
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        recyclerView.addItemDecoration(new MyDecoration());
        recyclerView.setAdapter(new BirthAdapter(getContext()));
        loadBanner();
    }

    List<Integer> imageList;
    private void loadBanner(){

        if (imageList==null){
            imageList=new ArrayList<>();
        }
        imageList.add(R.mipmap.roundplay_1);
        imageList.add(R.mipmap.roundplay_2);
        imageList.add(R.mipmap.roundplay_3);
        RequestOptions myOptions =new RequestOptions()
                .transform((new MultiTransformation(new CenterCrop(), new RoundedCorners(DensityUtil.dip2px(getContext(),10)))));
        bannerView.isAutoPlay(true);
        bannerView.setDelayTime(3000);
        setBannerImage(bannerView,myOptions);

    }

    void setBannerImage(BannerView view, RequestOptions options) {
        view.setAdapter(new BannerAdapter<Integer>(imageList) {
            @Override
            public void bindImage(ImageView imageView, Integer item) {
                Glide.with(getContext()).load(item).error(R.drawable.ic_logo).apply(options).into(imageView);
            }

            @Override
            public void bindTitle(TextView titleText, Integer item) {

            }

            @Override
            public void onItemClicked(int position, Integer item) {

            }
        });
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            int gap = 20;
            outRect.set(0,0,0,gap);

        }
    }

}
