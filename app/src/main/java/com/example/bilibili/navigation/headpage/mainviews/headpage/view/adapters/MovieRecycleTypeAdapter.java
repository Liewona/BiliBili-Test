package com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bilibili.R;

public class MovieRecycleTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    public MovieRecycleTypeAdapter(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;
        View view=LayoutInflater.from(context).inflate(R.layout.movie_recommand_type,parent,false);
        holder=new MovieRecycleShowOneHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MovieRecycleShowOneHolder myholder=(MovieRecycleShowOneHolder)holder;
        switch (position){
            case 0:
                myholder.tvType.setText("不给糖就捣乱");
                break;
            case 1:
                myholder.tvType.setText("哈利波特全集");
                break;
            case 2:
                myholder.tvType.setText("卓别林诞辰130周年！致敬喜剧之王");
                break;
            case 3:
                myholder.tvType.setText("B站神剧集合 搭配弹幕快乐翻翻");
                break;
            case 4:
                myholder.tvType.setText("最心动的感觉！ 不得不看的经典爱情片");
                break;
            case 5:
                myholder.tvType.setText("BBC出品 精品保证");
                break;
            case 6:
                myholder.tvType.setText("奥斯卡金像奖影片");
                break;

        }


    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class MovieRecycleShowOneHolder extends RecyclerView.ViewHolder {

        TextView tvType;

        public MovieRecycleShowOneHolder(@NonNull View itemView) {
            super(itemView);
            tvType=itemView.findViewById(R.id.show_type);
        }
    }
}
