package com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bilibili.R;

public class ChaseRecycleShowTwoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    public ChaseRecycleShowTwoAdapter(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;
        View view=LayoutInflater.from(context).inflate(R.layout.chase_recycleshowtwo,parent,false);
        holder=new ChaseRecycleShowTwoHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChaseRecycleShowTwoHolder myholder= (ChaseRecycleShowTwoHolder) holder;
        switch (position){
            case 1:
                myholder.showTile.setText("热门番剧");
                break;
            case 2:
                myholder.showTile.setText("热门国创");
                break;
            case 3:
                myholder.showTile.setText("热门国创相关");
                break;
            case 4:
                myholder.showTile.setText("热门改编");
                break;
            case 0:
                myholder.showTile.setText("热门新番");
                break;

        }

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class ChaseRecycleShowTwoHolder extends RecyclerView.ViewHolder {

        TextView showTile;

        public ChaseRecycleShowTwoHolder(@NonNull View itemView) {
            super(itemView);
            showTile=itemView.findViewById(R.id.show_tile);
        }
    }
}
