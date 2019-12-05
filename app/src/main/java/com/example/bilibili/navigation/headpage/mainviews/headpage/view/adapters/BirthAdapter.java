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

public class BirthAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<String> imagelist;
    private List<String> intros;
    private List<String> types;
    private List<String> titles;

    public BirthAdapter(Context context){
        this.context = context;
        LoadData();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BirthAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_birth_recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        setData(holder,position);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
    class BirthAdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView_item1,imageView_item2,imageView_item3,imageView_item4;
        private TextView tv_intro_item1,tv_intro_item2,tv_intro_item3,tv_intro_item4,tv_type_item1,
                tv_type_item2,tv_type_item3,tv_type_item4,tv_title;
        public BirthAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            imageView_item1 = itemView.findViewById(R.id.image_item1);
            imageView_item2 = itemView.findViewById(R.id.image_item2);
            imageView_item3 = itemView.findViewById(R.id.image_item3);
            imageView_item4 = itemView.findViewById(R.id.image_item4);
            tv_intro_item1 = itemView.findViewById(R.id.tv_intro_item1);
            tv_intro_item2 = itemView.findViewById(R.id.tv_intro_item2);
            tv_intro_item3 = itemView.findViewById(R.id.tv_intro_item3);
            tv_intro_item4 = itemView.findViewById(R.id.tv_intro_item4);
            tv_type_item1 = itemView.findViewById(R.id.tv_type_item1);
            tv_type_item2 = itemView.findViewById(R.id.tv_type_item2);
            tv_type_item3 = itemView.findViewById(R.id.tv_type_item3);
            tv_type_item4 = itemView.findViewById(R.id.tv_type_item4);
        }
    }

    private void setData(RecyclerView.ViewHolder holder,int pos){
        if(holder instanceof BirthAdapterViewHolder){
            ((BirthAdapterViewHolder) holder).tv_title.setText(titles.get(pos));
            Glide.with(context).load(imagelist.get(pos%imagelist.size())).into(((BirthAdapterViewHolder) holder).imageView_item1);
            Glide.with(context).load(imagelist.get((pos+1)%imagelist.size())).into(((BirthAdapterViewHolder) holder).imageView_item2);
            Glide.with(context).load(imagelist.get((pos+2)%imagelist.size())).into(((BirthAdapterViewHolder) holder).imageView_item3);
            Glide.with(context).load(imagelist.get((pos+3)%imagelist.size())).into(((BirthAdapterViewHolder) holder).imageView_item4);
            ((BirthAdapterViewHolder) holder).tv_intro_item1.setText(intros.get(pos%intros.size()));
            ((BirthAdapterViewHolder) holder).tv_intro_item2.setText(intros.get((pos+1)%intros.size()));
            ((BirthAdapterViewHolder) holder).tv_intro_item3.setText(intros.get((pos+2)%intros.size()));
            ((BirthAdapterViewHolder) holder).tv_intro_item4.setText(intros.get((pos+3)%intros.size()));
            ((BirthAdapterViewHolder) holder).tv_type_item1.setText(types.get(pos%types.size()));
            ((BirthAdapterViewHolder) holder).tv_type_item2.setText(types.get((pos+1)%types.size()));
            ((BirthAdapterViewHolder) holder).tv_type_item3.setText(types.get((pos+2)%types.size()));
            ((BirthAdapterViewHolder) holder).tv_type_item4.setText(types.get((pos=3)%types.size()));
        }
    }
    private void init(){
        if(imagelist == null){
            imagelist = new ArrayList<>();
        }
        if (intros == null){
            intros = new ArrayList<>();
        }
        if(types == null){
            types = new ArrayList<>();
        }
        if(titles == null){
            titles = new ArrayList<>();
        }
    }

    private void LoadData(){
        init();
        imagelist.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1685775496,1648065249&fm=26&gp=0.jpg");
        imagelist.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3632520016,1837355770&fm=26&gp=0.jpg");
        imagelist.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575029841691&di=47b2ccce338480f9e2aca813c1163e34&imgtype=0&src=http%3A%2F%2Fp0.qhimgs4.com%2Ft01faf4f6ceaa27c44c.jpg");
        imagelist.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575029891401&di=8a8821c492b93ff90361f725043be102&imgtype=0&src=http%3A%2F%2Fimg.mp.sohu.com%2Fupload%2F20170811%2F4943d2db1c8348cbb7c07d9ba2d094cf_th.png");
        imagelist.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575029970524&di=01b30110efd07690877acacc51db8c3f&imgtype=0&src=http%3A%2F%2Fimg1.i21st.cn%2Fuploads%2Fstory%2Fd3%2F69%2FIMG_9489%2F1.thumb.jpg");
        imagelist.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575030081919&di=b0dff05b21cb5916aa28ab3e9df6fbfa&imgtype=0&src=http%3A%2F%2Fimg.hkwb.net%2Fattachement%2Fpng%2Fsite2%2F20191027%2F94c6912ae6d51f1f88c03d.png");
        imagelist.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575030186276&di=9ce04e87da1a75e883cc1dd5c6c71546&imgtype=0&src=http%3A%2F%2Fimg01.cztv.com%2F201910%2F01%2Ff5307555b2acf65e77bc3dbab6216c21.jpg");
        imagelist.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575035552600&di=9b5f6e4dc54b5eb9be3c511bd3495582&imgtype=0&src=http%3A%2F%2Fwww.xydjw.gov.cn%2Fuploadfile%2F201910%2F20191014105633280.jpg");
        intros.add("【纪录片】习近平治国方略：中国这五年");
        intros.add("“寻访英雄”网络互动活动 活动宣传片");
        intros.add("挖掘英雄故事 找寻英雄足迹 具体操作流程都在这里了");
        intros.add("超燃！哔哩哔哩快闪，祝贺新中国70华诞！");
        intros.add("91 岁任坚守方桌，剪艺宗师袁秀莹与她的剪纸人生");
        intros.add("《让城市更美好我们是认真的》--新中国成立70周年“珍惜自然资源、建设美丽中国”短视频");
        intros.add("被称为中国三宝之一的它，却不及日本，面临失传... ...");
        intros.add("钢铁意志常在 赤城忠心不改 爆燃混剪重温9.3阅兵");
        intros.add("【青课2.0 好哈学习】第6集 《社会主义核心价值与青年》 万资姿");
        intros.add("纪念五四运动100周年 - 青春与祖国同在");
        intros.add("【我的国 409】 40年给我们带来了什么，从奢侈品到消费品看40年改变");
        titles.add("寻访英雄");
        titles.add("我和我的祖国");
        titles.add("手造中国");
        titles.add("国家版图意识宣传周");
        titles.add("70年来它们惊艳世界");
        titles.add("70华诞，献礼纪录片");
        titles.add("国家宝藏");
        titles.add("我在b站上党课");
        titles.add("光影70年，经典剧集展播");
        titles.add("2019我们都是追梦人");
        titles.add("科普纪录片《了不起我的国》");
        titles.add("献礼70年，致敬新中国");
        types.add("日常");
        types.add("综艺");
        types.add("短片");
        types.add("纪录片");
        types.add("军事");
        types.add("演奏");
    }
}
