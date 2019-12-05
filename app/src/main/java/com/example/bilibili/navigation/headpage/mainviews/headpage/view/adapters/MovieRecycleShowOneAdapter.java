package com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bilibili.R;

public class MovieRecycleShowOneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    public MovieRecycleShowOneAdapter(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;
        View view=LayoutInflater.from(context).inflate(R.layout.movie_show_soon,parent,false);
        holder=new MovieRecycleShowOneHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MovieRecycleShowOneHolder myholder=(MovieRecycleShowOneHolder)holder;
        if (position==0){
            myholder.headLine.setVisibility(View.INVISIBLE);
            myholder.movieTile.setText("申肖克的救赎");
            myholder.time.setText("今天 00:00");


        }
        if (position==1){
            myholder.movieTile.setText("这个杀手不太冷");
            myholder.time.setText("11-1 8:00");
            myholder.imageView.setImageResource(R.mipmap.soon_bg_3);
        }
        if (position==2){
            myholder.time.setText("11-15 21:00");
            myholder.imageView.setImageResource(R.mipmap.soon_bg_2);
        }
        if (position==getItemCount()-1){
            myholder.bottomLine.setVisibility(View.INVISIBLE);
            myholder.movieTile.setText("阿甘正传");
            myholder.time.setText("12-5 8:00");
            myholder.imageView.setImageResource(R.mipmap.soon_bg_5);
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class MovieRecycleShowOneHolder extends RecyclerView.ViewHolder {

        View headLine;
        View bottomLine;
        TextView movieTile;
        TextView time;
        ImageView imageView;

        public MovieRecycleShowOneHolder(@NonNull View itemView) {
            super(itemView);
            headLine=itemView.findViewById(R.id.line_head);
            bottomLine=itemView.findViewById(R.id.line_bottom);
            movieTile=itemView.findViewById(R.id.movie_tile);
            time=itemView.findViewById(R.id.movie_time);
            imageView=itemView.findViewById(R.id.movie_im);



        }
    }
}
