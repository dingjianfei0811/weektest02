package com.bawei.dingjianfei20200106.base;

/**
 * 作者：丁建飞
 * 时间：2020/1/6  9:10
 * 类名：com.bawei.dingjianfei20200106.base
 */
public abstract class BasePresenter <V> {
    protected  V view;

    public void attach(V view) {
        this.view = view;
    }
    public void dttdch() {
       view=null;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
