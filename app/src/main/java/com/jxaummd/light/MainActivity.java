package com.jxaummd.light;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.joker.annotation.PermissionsGranted;
import com.joker.api.Permissions4M;
import com.jxaummd.light.base.view.FragmentTab;
import com.jxaummd.light.base.view.FragmentTabHost;
import com.jxaummd.light.base.view.HomePageFragment;
import com.jxaummd.light.base.view.MusicPageFragment;
import com.jxaummd.light.base.view.MyselfPageFrangment;
import com.jxaummd.light.base.view.StorePageFragment;
import com.jxaummd.light.hardware.BluetoothLeService;
import com.jxaummd.light.hardware.MediaPlayService;
import com.jxaummd.light.hardware.SpeechOperator;
import com.jxaummd.light.hardware.SpeechRecWakService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private FragmentTabHost mTabHost;
    private LayoutInflater mInflater;
    private List<FragmentTab> fragmentTbaList ;
    public static  Activity activity;
    Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();         //初始化界面
        initpermission();   //初始化权限
        activity=this;
        initStatuBar();
    }

    private void setStatusColor(int red) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(red);
        }
    }

    private void initStatuBar() {
        window = MainActivity.activity.getWindow();
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色

    }






    private void initpermission() {
        Permissions4M.get(MainActivity.this).requestForce(true)
                .requestPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                .requestCode(0) .request();
        if ( ! BluetoothAdapter.getDefaultAdapter().isEnabled()) {//蓝牙未开启
            BluetoothAdapter.getDefaultAdapter().enable();

        }

    }


    @PermissionsGranted({0,1,2})
    public void granted(int code) {
            MyApplication.MyToast("");
    }


    private void initView() {
        setContentView(R.layout.activity_main);
        mInflater=LayoutInflater.from(this);

        mTabHost=findViewById(android.R.id.tabhost);
        mTabHost.setup(this,getSupportFragmentManager(),R.id.flayout_content);

        //三个界面，三个Fragment
        fragmentTbaList= new ArrayList<>();
        FragmentTab tab = new FragmentTab(R.drawable.main_bottom_home_selector,"home", HomePageFragment.class,v -> {setStatusColor(getResources().getColor(R.color.colorPrimaryDark));});
        FragmentTab music = new FragmentTab(R.drawable.main_bottom_music_selector,"music", MusicPageFragment.class,v -> {setStatusColor(getResources().getColor(R.color.white));});
        FragmentTab tab2 = new FragmentTab(R.drawable.main_bottom_myself_selector,"myself", MyselfPageFrangment.class,v -> {setStatusColor(getResources().getColor(R.color.colorPrimaryDark));MyApplication.MyToast("  color");});

        fragmentTbaList.add(tab);
        fragmentTbaList.add(music);
        fragmentTbaList.add(tab2);

        //添加到FragmentTabHost中
        for (FragmentTab tabs:
             fragmentTbaList) {
            TabHost.TabSpec  tabSpec  = mTabHost.newTabSpec(tabs.getTitle()).setIndicator(buildIndicator(tabs));
            mTabHost.addTab(tabSpec,tabs.getFragment(),null);
        }
        //设置启动的fragment
        mTabHost.setCurrentTab(0);


        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                switch (tabId){
                    case "home":
                        setStatusColor(getResources().getColor(R.color.colorPrimaryDark));
                        break;
                     case "music":
                         setStatusColor(getResources().getColor(R.color.blue));
                         break;
                    case  "myself":
                        setStatusColor(getResources().getColor(R.color.colorPrimaryDark));
                        break;
                }
            }
        });

    }

    //构建Indicator
    private View buildIndicator(FragmentTab tab){
        View view =mInflater.inflate(R.layout.tab_indicator,null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        img.setImageResource(tab.getIcon());
     //   img.setOnClickListener(tab.getiOnclickListener());
        return  view;
    }

    @Override
    protected void onResume() {
        super.onResume();
        initService();          //初始化线程
    }


    //初始化线程
    private void initService() {

        Intent intent = new Intent(this, SpeechRecWakService.class);
        startService(intent);
        intent = new Intent(this, MediaPlayService.class);
        startService(intent);
        intent = new Intent(this, BluetoothLeService.class);
        startService(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
