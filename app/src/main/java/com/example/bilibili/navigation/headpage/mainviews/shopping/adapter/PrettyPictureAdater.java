package com.example.bilibili.navigation.headpage.mainviews.shopping.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.bilibili.R;

import androidx.recyclerview.widget.RecyclerView;

public class PrettyPictureAdater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private onIntemClickListener listener;

    public PrettyPictureAdater(Context context, onIntemClickListener listener){
        this.context = context;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new PrettypictureViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_pretty_picture_item,null));

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {

        ((PrettypictureViewHolder)viewHolder).textView.setOnClickListener(new View.OnClickListener() {
            private boolean isDianzan = false;
            @Override
            public void onClick(View v) {
                if(!isDianzan){
                    isDianzan = true;
                    Drawable drawable = context.getResources().getDrawable(R.drawable.dianzan_1);
                    drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
                    ((PrettypictureViewHolder)viewHolder).textView.setCompoundDrawables(drawable,null,null,null);
                }else{
                    isDianzan = false;
                    Drawable drawable = context.getResources().getDrawable(R.drawable.dianzan);
                    drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
                    ((PrettypictureViewHolder)viewHolder).textView.setCompoundDrawables(drawable,null,null,null);
                }
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class PrettypictureViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public PrettypictureViewHolder( View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_4);
        }
    }

    public interface onIntemClickListener{
        void OnClick(int pos);
    }
}
