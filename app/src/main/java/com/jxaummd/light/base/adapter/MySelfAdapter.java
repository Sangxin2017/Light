package com.jxaummd.light.base.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jxaummd.light.MyApplication;
import com.jxaummd.light.R;
import com.jxaummd.light.base.iface.IOnclickListener;
import com.jxaummd.light.base.net.BaseNetGetRequest;
import com.jxaummd.light.hardware.BleOperator;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sangx on 2018/2/23.
 */

public class MySelfAdapter extends RecyclerView.Adapter<MySelfAdapter.MyViewHolder> {
    private List<SetItem> list=new ArrayList<>();
    private  BaseNetGetRequest request= new BaseNetGetRequest();

    public  void addItem(int image,String title){
        list.add(new SetItem(image,title));
    }

    public  void addItem(int image,String title,IOnclickListener iOnclickListener){
        list.add(new SetItem(image,title,iOnclickListener));
    }

    public  void addItem(int image,String title,IOnclickListener iOnclickListener,boolean is){
        list.add(new SetItem(image,title,iOnclickListener,is));
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myself_set_list,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
                if(list.get(position).getImage_id()==0){
                    holder.image.setVisibility(View.GONE);
                }else {
                    holder.image.setImageResource(list.get(position).getImage_id());
                }
                holder.title.setText(list.get(position).getTitle());
              //  holder.fuzhuline.setBackgroundColor(Color.RED);
                //设置单击事件
                if(list.get(position).getiOnclickListener()!=null){
                    holder.view.setOnClickListener(list.get(position).getiOnclickListener());
                }

                if(!list.get(position).isIshavejiantou()){
                    holder.jiantou.setVisibility(View.GONE);
                }
                }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView image;
        ImageView jiantou ;
        TextView fuzhuline;
        View  view;

        public MyViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            jiantou=itemView.findViewById(R.id.set_item_jiantou);
            title=itemView.findViewById(R.id.set_item_text);
            image=itemView.findViewById(R.id.set_item_image);
            fuzhuline=itemView.findViewById(R.id.fuzhu_line);
        }
    }



    public class  SetItem {
        private int image_id;
        private String title;
        private IOnclickListener  iOnclickListener;
        private  boolean ishavejiantou =  true;

        public SetItem(int image_id, String title, IOnclickListener iOnclickListener, boolean ishavejiantou) {
            this.image_id = image_id;
            this.title = title;
            this.iOnclickListener = iOnclickListener;
            this.ishavejiantou = ishavejiantou;
        }

        public SetItem(int image_id, String title, IOnclickListener iOnclickListener) {
            this.image_id = image_id;
            this.title = title;
            this.iOnclickListener = iOnclickListener;
        }


        public SetItem(int image_id, String title) {
            this.image_id = image_id;
            this.title = title;
        }


        public int getImage_id() {
            return image_id;
        }

        public void setImage_id(int image_id) {
            this.image_id = image_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public IOnclickListener getiOnclickListener() {
            return iOnclickListener;
        }

        public void setiOnclickListener(IOnclickListener iOnclickListener) {
            this.iOnclickListener = iOnclickListener;
        }

        public boolean isIshavejiantou() {
            return ishavejiantou;
        }

        public void setIshavejiantou(boolean ishavejiantou) {
            this.ishavejiantou = ishavejiantou;
        }
    }

}

