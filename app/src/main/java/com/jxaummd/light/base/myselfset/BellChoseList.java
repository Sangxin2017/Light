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
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.jxaummd.light.MainActivity;
import com.jxaummd.light.R;
import com.jxaummd.light.base.adapter.SetListStringAdapter;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;

public class BellChoseList extends AppCompatActivity{
    private RecyclerView SettingList;
    private SetListStringAdapter mySelfAdapter;
    private Toolbar toolbar ;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_set_layout);
        toolbar = findViewById(R.id.set_page_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("铃声选择");


        SettingList = findViewById(R.id.myself_myselflist);
        mySelfAdapter = new SetListStringAdapter();
        mySelfAdapter.addItem("春风吹", "春风一吹忘了谁", v->showDialog("春风吹","高三那年的愚人节，我喜欢的女生给了我一块奥利奥，还亲手塞进我的嘴，卧槽，知道吗，我当时脸都红了，当我咬碎发现味道怪怪的，里面加了牙膏，我没吐出来，全咽下去了  她当时还急了，你快吐出来里面有牙膏你怎么咽下去了，我看着她说因为是你给我的，她脸红了，就在那天我们在一起了直到现在"));

        mySelfAdapter.addItem("起风了", "逆着光行走,任风吹雨打",v->showDialog("起风了","第一杯酒敬你，所谓不合适就是你喜欢清风醉酒，我却独爱烈风自由。\n" +
                "第二杯酒敬你，岁月里你很干净，比水淡，比酒清。\n" +
                "第三杯酒敬你，黄昏时偷来你的肋骨酿酒，百年后醉的有血有肉。\n" +
                "第四杯酒敬你，晚风路过陶坛吹散的酒香，我记得你所有模样。"));

//        mySelfAdapter.addItem("琼花房", "风清水摇船荡 游鱼借着亭亭荷叶盖夕阳", v->showDialog("春风吹","一个炎热的夏天，一段悠远的回忆，记得那时候的天真烂漫、无忧无虑，而如今体会到人间冷暖、时态炎凉"));
        mySelfAdapter.addItem("琼花房", "风清水摇船荡 游鱼借着亭亭荷叶盖夕阳", v->showDialog("琼花房","就是这种迷幻的感觉。像极了记忆中某个夏天，你眯着眼靠在树下乘凉，头顶的蝉鸣和植物一样茂盛，被树叶摇碎的阳光，就这样在你脸上晃啊晃，晃啊晃，晃啊晃·····晃到你睁开眼，发现季节反转，你也已经不在原来那个地方。"));
        //

        mySelfAdapter.addItem("送别", "长亭外，古道边，芳草碧连天", v->showDialog("送别","弘一法师在俗时，有年冬天，大雪纷飞，好友许幻园站在门外喊出李叔同和叶子小姐，说：“叔同兄，我家破产了，咱们后会有期。”说完，挥泪而别。李叔同看着昔日好友远去的背影，在雪里站了很久随后，李叔同返身回到屋内，让叶子小姐弹琴，他便含泪写下：长亭外，古道边，芳草碧连天……"));

        mySelfAdapter.addItem("声声慢","青砖伴瓦漆,白马踏新泥",v->showDialog("声声慢","今天爸爸在家自己染头，人到中年了有白头发很正常啊，我就问他“爸，你都快50了还染头发干嘛啊，还想勾搭女人去啊” 我爸说“每次我回老家前都把头发染黑，那样你奶奶看见就会以为我年轻，她也不老了”"));

        SettingList.setLayoutManager(new LinearLayoutManager(MainActivity.activity, LinearLayoutManager.VERTICAL, true));
        SettingList.setAdapter(mySelfAdapter);

    }


    void  showDialog(String title,String content){
        new TDialog.Builder(getSupportFragmentManager())
                .setCancelableOutside(true)
                .setGravity(Gravity.CENTER)
                .setWidth(600)  //设置弹窗固定宽度(单位:px)
                .setHeight(800)//设置弹窗固定高度
                .setScreenWidthAspect(BellChoseList.this,0.7f) //动态设置弹窗宽度为屏幕宽度百分比(取值0-1f)
                .setScreenHeightAspect(BellChoseList.this,0.6f)//设置弹窗高度为屏幕高度百分比(取值0-1f)
                .setDimAmount(0.6f)
                .setLayoutRes(R.layout.set_about_software)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        viewHolder.setVisibility(R.id.set_about_software_toolbar, View.GONE);
                        viewHolder.setText(R.id.set_app_about_software_content,content);
                        viewHolder.setText(R.id.set_app_about_software_title,title);

                    }
                })
                .create()
                .show();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return  true;
    }


}
