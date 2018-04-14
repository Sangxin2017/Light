package com.jxaummd.light.base.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.jxaummd.light.MainActivity;
import com.jxaummd.light.MyApplication;
import com.jxaummd.light.R;
import com.jxaummd.light.base.adapter.MySelfAdapter;
import com.jxaummd.light.base.iface.IOnclickListener;
import com.jxaummd.light.base.myselfset.AboutSoftWare;
import com.jxaummd.light.base.myselfset.BellChoseList;
import com.jxaummd.light.base.myselfset.ChoseVoicePeople;
import com.jxaummd.light.base.myselfset.ChoseWarkUpWord;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by sangx on 2018/2/20.
 */

public class MyselfPageFrangment extends Fragment{
    private RecyclerView SettingList;
    private MySelfAdapter mySelfAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myself_layout,container,false);
        SettingList=view.findViewById(R.id.myself_myselflist);
        mySelfAdapter = new MySelfAdapter();
        mySelfAdapter.addItem(R.drawable.geren_guangyuwomen,"关于软件",v ->startActivity(new Intent(MainActivity.activity,AboutSoftWare.class)));
        mySelfAdapter.addItem(R.drawable.geren_fayinren,"发音人选择",v->startActivity(new Intent(MainActivity.activity,ChoseVoicePeople.class)));
        mySelfAdapter.addItem(R.drawable.geren_guanjianci,"唤醒词选择",v->startActivity(new Intent(MainActivity.activity,ChoseWarkUpWord.class)));
        mySelfAdapter.addItem(R.drawable.geren_shebeiguanli,"设备管理");
        mySelfAdapter.addItem(R.drawable.geren_naozhong,"闹铃选择",v->startActivity(new Intent(MainActivity.activity,BellChoseList.class)));
        mySelfAdapter.addItem(R.drawable.geren_gexinghua,"个性定制");
        SettingList.setLayoutManager(new LinearLayoutManager(MainActivity.activity,LinearLayoutManager.VERTICAL,true));
        SettingList.setAdapter(mySelfAdapter);

        return view;
    }
}
