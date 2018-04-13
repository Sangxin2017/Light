package com.jxaummd.light.base.myselfset;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jxaummd.light.MainActivity;
import com.jxaummd.light.R;
import com.jxaummd.light.base.adapter.MySelfAdapter;

public class ChoseWarkUpWord extends AppCompatActivity {
    private RecyclerView SettingList;
    private MySelfAdapter mySelfAdapter;
    private Toolbar  toolbar ;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_set_layout);
        toolbar=findViewById(R.id.set_page_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        ActionBar  actionBar  =  getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("发音人选择");





        SettingList=findViewById(R.id.myself_myselflist);
        mySelfAdapter = new MySelfAdapter();
        mySelfAdapter.addItem(0, "小娜同学",v->startActivity(new Intent(MainActivity.activity,ChoseWarkUpWord.class)),false);
        mySelfAdapter.addItem(0,"智能台灯",null,false);
        mySelfAdapter.addItem(0,"桑欣同学",null,false);
        SettingList.setLayoutManager(new LinearLayoutManager(MainActivity.activity,LinearLayoutManager.VERTICAL,true));
        SettingList.setAdapter(mySelfAdapter);

    }


}
