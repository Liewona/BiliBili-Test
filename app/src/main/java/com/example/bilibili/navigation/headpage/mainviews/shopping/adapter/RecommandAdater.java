package com.example.bilibili.navigation.headpage.mainviews.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.bilibili.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RecommandAdater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Integer> recommandiamgelist = new ArrayList<>();
    private List<String> recommandtextlist = new ArrayList<>();
    private onIntemClickListener listener;
    private Integer IMAGESIZE;

    public RecommandAdater(Context context, onIntemClickListener listener){
        this.context = context;
        this.listener = listener;
        InputData();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecommandViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_recommand__item,null));

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        if(IMAGESIZE > 0){
            ((RecommandViewHolder)viewHolder).imageView.setImageResource(recommandiamgelist.get(IMAGESIZE-1));
            IMAGESIZE--;
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recommandiamgelist.size() + 1;
    }

    class RecommandViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;

        public RecommandViewHolder( View itemView) {
            super(itemView);
            //textView = itemView.findViewById(R.id.tv_text);
            imageView = itemView.findViewById(R.id.top_iv1);
        }
    }

    public interface onIntemClickListener{
        void OnClick(int pos);
    }

    @Override
    public int getItemViewType(int position) {
        if(position %2 == 0){
            return 0;
        }else{
            return 1;
        }
    }

    public void InputData(){
        recommandiamgelist.add(R.drawable.a);
        recommandiamgelist.add(R.drawable.a);
        recommandiamgelist.add(R.drawable.a);
        recommandiamgelist.add(R.drawable.a);
        recommandiamgelist.add(R.drawable.a);
        recommandiamgelist.add(R.drawable.a);
        recommandiamgelist.add(R.drawable.a);
        recommandiamgelist.add(R.drawable.a);
        IMAGESIZE = recommandiamgelist.size();
    }
}
