package com.example.bilibili.laiyu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bilibili.R;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViewById(R.id.register_passwordlogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_rback).setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                onBackPressed();
            }
        });
    }
}
