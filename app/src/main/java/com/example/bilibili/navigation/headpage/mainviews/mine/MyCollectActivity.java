package com.example.bilibili.navigation.headpage.mainviews.mine;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.bilibili.R;
import com.example.bilibili.navigation.headpage.mainviews.mine.Adapter.ListViewAdapter;
import com.example.bilibili.navigation.headpage.mainviews.mine.Entity.Infor;

import java.util.ArrayList;
import java.util.List;

public class MyCollectActivity extends Activity {

    private Button back_mine;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collect);
        init();
        back_mine=findViewById(R.id.btn_mycollect_back_mine);
        back_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    onBackPressed();
            }
        });
    }

    private void init() {
        listView=findViewById(R.id.lv_my_collect);
        List<Infor> inforlist = new ArrayList<>();

        for( int i = 1; i <= 8 ; i++) {
            Infor infor = new Infor();      //循环创建studentData 对象
            infor.setHead_source(R.drawable.video_1);
            infor.setNickname("【甜甜圈女神+中字】高卡路里欺骗餐挑战！甜甜圈、披萨、冰淇淋、薯片！");          //为对象设置姓名
            infor.setWord("UP主：好吃的甜豆");                             //为对象设置 年龄
            infor.setFollowyet("=已关注");              //为对象设置照片
            inforlist.add(infor);                  //将对象添加到列表中
        }
        ListViewAdapter listViewAdapter=new ListViewAdapter(inforlist,this);
        listView.setAdapter(listViewAdapter);
    }
}
