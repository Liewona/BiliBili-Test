package com.example.bilibili.navigation.headpage.mainviews.mine;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bilibili.R;

public class LiveCenterActivity extends Activity {

    private Button back_mine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_center);

        back_mine=findViewById(R.id.btn_livecenter_back_mine);
        back_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
