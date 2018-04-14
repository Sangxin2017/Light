package com.jxaummd.light.base.view;

import com.jxaummd.light.base.iface.IOnclickListener;

/**
 * Created by sangx on 2018/2/20.
 */

public class FragmentTab {
    private  int icon;
    private  String  title;
    private  Class  fragment;
    private IOnclickListener  iOnclickListener;

    public FragmentTab(int icon, String title, Class fragment, IOnclickListener iOnclickListener) {
        this.icon = icon;
        this.title = title;
        this.fragment = fragment;
        this.iOnclickListener = iOnclickListener;
    }

    public FragmentTab(int icon, String title, Class fragment) {
        this.icon = icon;
        this.title = title;
        this.fragment = fragment;
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

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }


    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
