package com.jxaummd.light.base.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jxaummd.light.R;
import com.jxaummd.light.base.iface.IOnclickListener;
import com.jxaummd.light.base.net.BaseNetGetRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sangx on 2018/2/23.
 */

public class SetListStringAdapter extends RecyclerView.Adapter<SetListStringAdapter.MyViewHolder> {
    private List<SetItem> list=new ArrayList<>();
    private  BaseNetGetRequest request= new BaseNetGetRequest();

    public  void addItem(String title,String summary){
        list.add(new SetItem(title,summary));
    }

    public  void addItem(String title,String summary,IOnclickListener onclickListener){
        list.add(new SetItem(title,summary,onclickListener));
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.set_list_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(list.get(position).title);
        holder.summary.setText(list.get(position).summary);
        if(list.get(position).iOnclickListener!=null){
            holder.view.setOnClickListener(list.get(position).iOnclickListener);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
            TextView  title;
            TextView  summary;
            View  view;

        public MyViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            summary=itemView.findViewById(R.id.set_list_item_summary);
            title=itemView.findViewById(R.id.set_list_item_title);
        }
    }


    public class  SetItem {
        String  title;
        String summary;
        IOnclickListener iOnclickListener;

        public SetItem(String title, String summary) {
            this.title = title;
            this.summary = summary;
        }

        public SetItem(String title, String summary, IOnclickListener iOnclickListener) {
            this.title = title;
            this.summary = summary;
            this.iOnclickListener = iOnclickListener;
        }

        public IOnclickListener getiOnclickListener() {
            return iOnclickListener;
        }

        public void setiOnclickListener(IOnclickListener iOnclickListener) {
            this.iOnclickListener = iOnclickListener;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
    }

    public List<SetItem> getList() {
        return list;
    }

    public void setList(List<SetItem> list) {
        this.list = list;
    }

    public BaseNetGetRequest getRequest() {
        return request;
    }

    public void setRequest(BaseNetGetRequest request) {
        this.request = request;
    }
}

