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

public class MyFollowActivity extends Activity {
    private Button backButton;
    private Button btn_follow_mine;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_follow);
        init();
        declare();
        BackMine();
        ChangePage();

    }

    private void ChangePage() {
        btn_follow_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (MyFollowActivity.this,FollowMineActivity.class);
                startActivity(intent);
            }
        });

    }

    private void init() {
        listView=findViewById(R.id.lv_myfollow);
        List<Infor> inforlist = new ArrayList<>();

        for( int i = 1; i <= 8 ; i++) {
            Infor infor = new Infor();      //循环创建studentData 对象
            infor.setHead_source(R.drawable.head_1);
            infor.setNickname("谷阿莫");          //为对象设置姓名
            infor.setWord("只想分享用心看的好电影");                             //为对象设置 年龄
            infor.setFollowyet("=已关注");              //为对象设置照片
            inforlist.add(infor);                  //将对象添加到列表中
        }
        ListViewAdapter listViewAdapter=new ListViewAdapter(inforlist,this);
        listView.setAdapter(listViewAdapter);

    }

    private void BackMine() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void declare() {
        backButton=findViewById(R.id.btn_backMine);
        btn_follow_mine=findViewById(R.id.btn_my_fans);
    }
}
