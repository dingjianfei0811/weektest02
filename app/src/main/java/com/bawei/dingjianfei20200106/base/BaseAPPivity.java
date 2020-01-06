package com.bawei.dingjianfei20200106.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * 作者：丁建飞
 * 时间：2020/1/6  9:11
 * 类名：com.bawei.dingjianfei20200106.base
 */
public  abstract class BaseAPPivity<P extends  BasePresenter> extends AppCompatActivity {
    protected  P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());

        mPresenter=priPresenter();

        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        ButterKnife.bind(this);
        initView();
        initDAte();
    }

    protected abstract void initDAte();

    protected abstract void initView();

    protected abstract P priPresenter();

    protected abstract int layoutId();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.dttdch();
        }

    }
}
