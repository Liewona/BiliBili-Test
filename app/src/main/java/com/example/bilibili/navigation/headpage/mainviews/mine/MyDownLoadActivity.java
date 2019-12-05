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

public class MyDownLoadActivity extends Activity {
    private Button download_back_mine;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_down_load);
        declare();
        init();
        BackMine();
    }

    private void init() {
        listView=findViewById(R.id.lv_my_download);
        List<Infor> inforlist = new ArrayList<>();

        for( int i = 1; i <= 8 ; i++) {
            Infor infor = new Infor();      //循环创建studentData 对象
            infor.setHead_source(R.drawable.video_2);
            infor.setNickname("【我家的熊孩子】");          //为对象设置姓名
            infor.setWord("UP主：李大头");                             //为对象设置 年龄
            infor.setFollowyet("=已关注");              //为对象设置照片
            inforlist.add(infor);                  //将对象添加到列表中
        }
        ListViewAdapter listViewAdapter=new ListViewAdapter(inforlist,this);
        listView.setAdapter(listViewAdapter);
    }

    private void BackMine() {
        download_back_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }



    private void declare() {
        download_back_mine=findViewById(R.id.btn_download_back_mine);
    }
}
