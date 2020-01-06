package com.bawei.dingjianfei20200106.model.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者：丁建飞
 * 时间：2020/1/6  10:27
 * 类名：com.bawei.dingjianfei20200106.model.dao
 */
@Entity
public class Dao2 {
    private  String b;

    @Generated(hash = 1698827560)
    public Dao2(String b) {
        this.b = b;
    }

    @Generated(hash = 1464613570)
    public Dao2() {
    }

    public String getB() {
        return this.b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
