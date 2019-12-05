package com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bilibili.R;

public class ChaseRecycleShowOneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    public ChaseRecycleShowOneAdapter(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;
        View view=LayoutInflater.from(context).inflate(R.layout.chase_recycleshowone,parent,false);
        holder=new ChaseRecycleShowOneHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class ChaseRecycleShowOneHolder extends RecyclerView.ViewHolder {

        public ChaseRecycleShowOneHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
