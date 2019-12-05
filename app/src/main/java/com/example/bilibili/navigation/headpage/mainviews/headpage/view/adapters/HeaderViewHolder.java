package com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters;

import android.view.View;

import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.bilibili.R;
import com.example.bilibili.utils.DensityUtil;
import com.lany.banner.BannerView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HeaderViewHolder extends RecyclerView.ViewHolder {
    public View bannerLayout;
    public BannerView bannerView;
    RequestOptions myOptions;
    public HeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        bannerLayout  = itemView;
        bannerView = itemView.findViewById(R.id.banner_view);
        myOptions =new RequestOptions()
                .transform((new MultiTransformation<>(new CenterCrop(), new RoundedCorners(DensityUtil.dip2px(itemView.getContext(),5)))));
    }
}
