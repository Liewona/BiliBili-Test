package com.example.bilibili.navigation.headpage.mainviews.mine;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bilibili.R;

public class MyLessonActivity extends Activity {
    private Button back_mine;
    private Button mycollect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lesson);
        mycollect=findViewById(R.id.btn_mylesson_mycollect);
        mycollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyLessonActivity.this,MyCollectActivity.class);
                startActivity(intent);
            }
        });
        back_mine=findViewById(R.id.btn_lesson_back_mine);
        back_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
