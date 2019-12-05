package com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bilibili.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DownLoadAndMessageAdapter extends RecyclerView.Adapter {
    private Context context;
    private int type;
    private List<String> images;
    private List<String> titles;

    public DownLoadAndMessageAdapter(Context context,int type){
        this.context = context;
        this.type = type;
        LoadData();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //type == 1 返回下载界面的view 否则返回信息界面的view
        if (type == 1){
            return new DownLoadViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_download_recycler_item,parent,false));
        }else{
            return new MessageViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_message_recycler_item,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        setData(holder,position);
    }

    class DownLoadViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewDownLoad;
        private TextView textViewTitle;
        public DownLoadViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewDownLoad = itemView.findViewById(R.id.image_down);
            textViewTitle = itemView.findViewById(R.id.tv_downTitle);
        }
    }
    class MessageViewHolder extends RecyclerView.ViewHolder {
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    private void setData(RecyclerView.ViewHolder holder,int pos){
        if (holder instanceof DownLoadViewHolder){
            Glide.with(context).load(images.get(pos)).into(((DownLoadViewHolder) holder).imageViewDownLoad);
            ((DownLoadViewHolder) holder).textViewTitle.setText(titles.get(pos));

        }
    }
    private void LoadData(){
        if (images == null){
            images = new ArrayList<>();
        }
        if (titles == null){
            titles = new ArrayList<>();
        }
        images.add("http://i0.hdslb.com/bfs/archive/0e75efdfb8441fd424c3ef82e95e2c2ad7791c54.jpg");
        images.add("http://i2.hdslb.com/bfs/archive/ac4ad60a441ad7d41c72d58a00f1bdd390ff9398.jpg");
        images.add("http://i1.hdslb.com/bfs/archive/5e3af2630681e52a06d62ed7c8c7a7ccbc84c5d1.jpg");
        images.add("http://i0.hdslb.com/bfs/archive/b7a65759d053fc3fd54a4fe51e3471917b969c07.jpg");
        titles.add("最近突然火起来的《Outside》太好听了，旋律太洗脑了!");
        titles.add("【绝代双骄】我们缅怀的是梅西c罗，更是自己的青春");
        titles.add("《七里香》送给你们，，秋刀鱼的滋味，猫跟你都想了解");
        titles.add("历史第一人！梅西第6次获得金球奖！梅西获奖完整视频");
    }
}
