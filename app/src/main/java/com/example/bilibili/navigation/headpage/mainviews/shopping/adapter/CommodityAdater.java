package com.example.bilibili.navigation.headpage.mainviews.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bilibili.R;
import com.example.bilibili.contentobj.CommodityBean;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class CommodityAdater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private onIntemClickListener listener;

    private List<CommodityBean> commodityBeans = new ArrayList<>();

    public CommodityAdater(Context context, onIntemClickListener listener){
        this.context = context;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecommendViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_commodity_item,null));

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        if(commodityBeans.size() == 0){
            return;
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnClick(position);
            }
        });
        ((RecommendViewHolder)viewHolder).textView.setText(commodityBeans.get(position).getTitle());
        Glide.with(context).load(commodityBeans.get(position).getPic()).into(((RecommendViewHolder)viewHolder).imageViewTop);

    }

    @Override
    public int getItemCount() {
        return commodityBeans.size();
    }

    class RecommendViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageViewTop;

        public RecommendViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_text);
            imageViewTop = itemView.findViewById(R.id.image_top);
        }
    }

    public interface onIntemClickListener{
        void OnClick(int pos);
    }
    public void setCommodityBeans(List<CommodityBean> commodityBeans){
        this.commodityBeans = commodityBeans;
    }

}
