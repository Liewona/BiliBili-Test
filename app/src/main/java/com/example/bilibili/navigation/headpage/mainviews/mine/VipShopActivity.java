package com.example.bilibili.navigation.headpage.mainviews.mine;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.bilibili.R;

public class VipShopActivity extends Activity {
    private Button back_mine;
    private ImageView mycollect;
    private ImageView myhistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip_shop);
        declare();
        Mycollect();
        Myhistory();
        backMine();

    }

    private void Myhistory() {
        myhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VipShopActivity.this,MyHistoryActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Mycollect() {
        mycollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VipShopActivity.this,MyCollectActivity.class);
                startActivity(intent);
            }
        });
    }

    private void backMine() {
        back_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void declare() {
        back_mine=findViewById(R.id.btn_vipshop_back_mine);
        mycollect=findViewById(R.id.ib_mycollect);
        myhistory=findViewById(R.id.ib_myhistory);
    }
}
