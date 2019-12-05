package com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bilibili.R;

public class MovieRecycleShowTwoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    public MovieRecycleShowTwoAdapter(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;
        View view=LayoutInflater.from(context).inflate(R.layout.chase_recycleshowtwo,parent,false);
        holder=new MovieRecycleShowTwoHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MovieRecycleShowTwoHolder viewHolder=(MovieRecycleShowTwoHolder) holder;
        switch (position){
            case 1:
                viewHolder.show_tile.setText("热门记录片");
                break;
            case 2:
                viewHolder.show_tile.setText("热门电视剧");
                break;
            case 3:
                viewHolder.show_tile.setText("热门电影");
                break;
            case 0:
                viewHolder.show_tile.setText("热门视频");
                break;
        }


    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class MovieRecycleShowTwoHolder extends RecyclerView.ViewHolder {

        TextView show_tile;
        public MovieRecycleShowTwoHolder(@NonNull View itemView) {
            super(itemView);
            show_tile=itemView.findViewById(R.id.show_tile);
        }
    }
}
