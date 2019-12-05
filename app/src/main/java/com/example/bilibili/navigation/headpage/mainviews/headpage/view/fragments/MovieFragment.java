package com.example.bilibili.navigation.headpage.mainviews.headpage.view.fragments;


import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
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
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters.MovieRecycleShowOneAdapter;
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters.MovieRecycleShowTwoAdapter;
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters.MovieRecycleTypeAdapter;
import com.example.bilibili.utils.DensityUtil;
import com.lany.banner.BannerAdapter;
import com.lany.banner.BannerView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {


    private BannerView bannerMovie;//轮播图
    private RecyclerView recyclerViewOne;
    private RecyclerView recyclerViewTwo;
    private RecyclerView recyclerViewThree;


    private Context context;
    List<Integer> imageList;


    public MovieFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context=getContext();
        bannerMovie=view.findViewById(R.id.movie_banner);
        recyclerViewOne=view.findViewById(R.id.movie_show_soon);
        recyclerViewTwo=view.findViewById(R.id.movie_show_top);
        recyclerViewThree=view.findViewById(R.id.movie_show_type);



        LinearLayoutManager l1=new LinearLayoutManager(context);
        l1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewOne.setLayoutManager(l1);
        recyclerViewOne.setAdapter(new MovieRecycleShowOneAdapter(context));

        LinearLayoutManager l2=new LinearLayoutManager(context);
        l2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewTwo.setLayoutManager(l2);
        recyclerViewTwo.setAdapter(new MovieRecycleShowTwoAdapter(context));
        recyclerViewTwo.addItemDecoration(new mydecortion());


        recyclerViewThree.setLayoutManager(new LinearLayoutManager(context));
        recyclerViewThree.setAdapter(new MovieRecycleTypeAdapter(context));

        loadBanner();

    }



    //加载轮播图
    private void loadBanner(){

        if (imageList==null){
            imageList=new ArrayList<>();
        }
        imageList.add(R.mipmap.roundplayer_1);
        imageList.add(R.mipmap.roundplayer_2);
        imageList.add(R.mipmap.roundplayer_3);
        RequestOptions myOptions =new RequestOptions()
                .transform((new MultiTransformation(new CenterCrop(), new RoundedCorners(DensityUtil.dip2px(context,10)))));
        bannerMovie.isAutoPlay(true);
        bannerMovie.setDelayTime(3000);
        setBannerImage(bannerMovie,myOptions);

    }

   //设置轮播图图片资源
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

   //recycleView 间距
    class mydecortion extends RecyclerView.ItemDecoration{

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap=getResources().getDimensionPixelOffset(R.dimen.search_show_box_padding_left);
            outRect.set(0,0,gap,0);
        }
    }


}
