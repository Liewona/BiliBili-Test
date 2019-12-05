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

public class FollowMineActivity extends Activity {
    private Button back_Mine;
    private Button my_follow;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_mine);

        declare();
        init();
        BackMine();
        MyFollow();
    }

    private void init() {
        listView=findViewById(R.id.lv_followmine);
        List<Infor> inforlist = new ArrayList<>();

        for( int i = 1; i <= 8 ; i++) {
            Infor infor = new Infor();      //循环创建studentData 对象
            infor.setHead_source(R.drawable.head_2);
            infor.setNickname("手工耿");          //为对象设置姓名
            infor.setWord("喜欢做一些有趣的小手工，欢迎大家提供一些有意思的想法。谢谢");                             //为对象设置 年龄
            infor.setFollowyet("=已关注");              //为对象设置照片
            inforlist.add(infor);                  //将对象添加到列表中
        }
        ListViewAdapter listViewAdapter=new ListViewAdapter(inforlist,this);
        listView.setAdapter(listViewAdapter);
    }

    private void MyFollow() {
        my_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FollowMineActivity.this,MyFollowActivity.class);
                startActivity(intent);
            }
        });
    }

    private void BackMine() {
        back_Mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void declare() {
        back_Mine=findViewById(R.id.btn_followmine_back_mine);
        my_follow=findViewById(R.id.btn_my_idol);
    }
}
