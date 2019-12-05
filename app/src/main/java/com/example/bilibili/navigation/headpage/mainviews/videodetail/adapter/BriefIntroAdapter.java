package com.example.bilibili.navigation.headpage.mainviews.videodetail.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bilibili.R;
import com.example.bilibili.contentobj.RecommendObject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BriefIntroAdapter extends RecyclerView.Adapter {
    private Context context;
    private int HEAD_TYPE = 0;
    private int TOPMOVIE_TYPE = 1;
    private int MOVIE_TYPE = 2;
    private RecommendObject recommendObject;

    public BriefIntroAdapter(Context context, RecommendObject recommendObject){
        this.context = context;
        this.recommendObject = recommendObject;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == HEAD_TYPE){
            return new HeadViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_briefintro_head,parent,false));
        }else if (viewType == TOPMOVIE_TYPE){
            return new TopMovieViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_briefintro_top_movie,parent,false));
        }else {
            return new MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_briefintro_movie,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        setHeadData(holder);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        if(holder instanceof HeadViewHolder){
            ((HeadViewHolder) holder).line_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(((HeadViewHolder) holder).tv_upOrDown.getTag().equals("up")){
                        ((HeadViewHolder) holder).tv_upOrDown.setTag("down");
                        ((HeadViewHolder) holder).tv_upOrDown.setImageResource(R.drawable.ic_xiala);
                        ((HeadViewHolder) holder).tv_title.setMaxLines(1);
                        ((HeadViewHolder) holder).tv_title.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                        ((HeadViewHolder) holder).tv_intro.setVisibility(View.GONE);

                    }else{
                        ((HeadViewHolder) holder).tv_upOrDown.setTag("up");
                        ((HeadViewHolder) holder).tv_upOrDown.setImageResource(R.drawable.ic_shangla);
                        ((HeadViewHolder) holder).tv_title.setMaxLines(100);
                        ((HeadViewHolder) holder).tv_title.setEllipsize(null);
                        ((HeadViewHolder) holder).tv_intro.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    }
    @Override
    public int getItemCount() {
        return 10;
    }

    class HeadViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_author,tv_title,tv_boFangLiang,tv_liulan,tv_create,tv_intro,tv_dianZan,tv_shouCang,tv_fenXiang;
        private ImageView tv_upOrDown;
        private LinearLayout line_click;

        public HeadViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_author = itemView.findViewById(R.id.tv_author);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_boFangLiang = itemView.findViewById(R.id.tv_boFangLiang);
            tv_liulan = itemView.findViewById(R.id.tv_liuLan);
            tv_create = itemView.findViewById(R.id.tv_createTime);
            tv_intro = itemView.findViewById(R.id.tv_intro);
            tv_dianZan = itemView.findViewById(R.id.tv_dianZan);
            tv_shouCang = itemView.findViewById(R.id.tv_shouCang);
            tv_fenXiang = itemView.findViewById(R.id.tv_fenXiang);
            tv_upOrDown = itemView.findViewById(R.id.upOrDown);
            line_click = itemView.findViewById(R.id.line_click);
        }
    }

    class TopMovieViewHolder extends RecyclerView.ViewHolder{
        private ImageView image_movie;
        private TextView tv_title, tv_author,tv_boFangLiang,tv_liulan,tv_fenlei;

        public TopMovieViewHolder(@NonNull View itemView) {
            super(itemView);
            image_movie = itemView.findViewById(R.id.iv_movie);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_boFangLiang = itemView.findViewById(R.id.tv_boFangLiang);
            tv_liulan = itemView.findViewById(R.id.tv_danmu);
            tv_author = itemView.findViewById(R.id.tv_author);
            tv_fenlei = itemView.findViewById(R.id.tv_fenlei);
        }
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_movie;
        private TextView tv_title, tv_author,tv_boFangLiang,tv_liulan;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            image_movie = itemView.findViewById(R.id.iv_movie);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_boFangLiang = itemView.findViewById(R.id.tv_boFangLiang);
            tv_liulan = itemView.findViewById(R.id.tv_danmu);
            tv_author = itemView.findViewById(R.id.tv_author);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return HEAD_TYPE;
        }else if(position == 1){
            return TOPMOVIE_TYPE;
        }else{
            return MOVIE_TYPE;
        }
    }

    private void setHeadData(RecyclerView.ViewHolder holder){
        if(holder instanceof HeadViewHolder){
            ((HeadViewHolder) holder).tv_author.setText(recommendObject.author);
            ((HeadViewHolder) holder).tv_title.setText(recommendObject.title);
            ((HeadViewHolder) holder).tv_boFangLiang.setText(recommendObject.play+"");
            ((HeadViewHolder) holder).tv_liulan.setText(recommendObject.videoReview+"");
            ((HeadViewHolder) holder).tv_create.setText(recommendObject.create);
            ((HeadViewHolder) holder).tv_intro.setText(recommendObject.description);
            ((HeadViewHolder) holder).tv_dianZan.setText(recommendObject.credit+"");
            ((HeadViewHolder) holder).tv_fenXiang.setText(recommendObject.coins+"");
            ((HeadViewHolder) holder).tv_shouCang.setText(recommendObject.favorites+"");
        }else if(holder instanceof TopMovieViewHolder){
            Glide.with(holder.itemView).load(recommendObject.pic).into(((TopMovieViewHolder) holder).image_movie);
            ((TopMovieViewHolder) holder).tv_title.setText(recommendObject.title);
            ((TopMovieViewHolder) holder).tv_author.setText(recommendObject.author);
            ((TopMovieViewHolder) holder).tv_boFangLiang.setText(recommendObject.play+"");
            ((TopMovieViewHolder) holder).tv_liulan.setText(recommendObject.videoReview+"");
            ((TopMovieViewHolder) holder).tv_fenlei.setText(recommendObject.typeName);
        }else if(holder instanceof MovieViewHolder){
            Glide.with(holder.itemView).load(recommendObject.pic).into(((MovieViewHolder) holder).image_movie);
            ((MovieViewHolder) holder).tv_title.setText(recommendObject.title);
            ((MovieViewHolder) holder).tv_author.setText(recommendObject.author);
            ((MovieViewHolder) holder).tv_boFangLiang.setText(recommendObject.play+"");
            ((MovieViewHolder) holder).tv_liulan.setText(recommendObject.videoReview+"");
        }else return;
    }
}
