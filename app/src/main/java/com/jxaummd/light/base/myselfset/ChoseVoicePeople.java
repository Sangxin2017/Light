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
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jxaummd.light.MainActivity;
import com.jxaummd.light.MyApplication;
import com.jxaummd.light.R;
import com.jxaummd.light.base.adapter.MySelfAdapter;
import com.jxaummd.light.base.adapter.SetListStringAdapter;
import com.jxaummd.light.base.iface.IOnclickListener;

public class ChoseVoicePeople extends AppCompatActivity {
    private RecyclerView SettingList;
    private SetListStringAdapter mySelfAdapter;
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
        mySelfAdapter = new SetListStringAdapter();
        mySelfAdapter.addItem("箜篌(男)","吴丝蜀桐张高秋，空山凝云颓不流。",v->startActivity(new Intent(MainActivity.activity,ChoseVoicePeople.class)));
        mySelfAdapter.addItem("霓裳羽衣曲(女)","骊宫高处入青云，仙乐风飘处处闻。",v->startActivity(new Intent(MainActivity.activity,ChoseVoicePeople.class)));
        mySelfAdapter.addItem( "古琴(女)","泠泠七弦遍，万木澄幽阴。",v->startActivity(new Intent(MainActivity.activity,ChoseVoicePeople.class)));
        mySelfAdapter.addItem( "笛(男)","此夜曲中闻折柳，何人不起故园情",v->startActivity(new Intent(MainActivity.activity,ChoseVoicePeople.class)));
        mySelfAdapter.addItem( "瑟(女)","千里潇湘挼蓝浦，兰桡昔日曾经。",v->startActivity(new Intent(MainActivity.activity,ChoseVoicePeople.class)));
        SettingList.setLayoutManager(new LinearLayoutManager(MainActivity.activity,LinearLayoutManager.VERTICAL,true));
        SettingList.setAdapter(mySelfAdapter);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();

        return  true;
    }
}
