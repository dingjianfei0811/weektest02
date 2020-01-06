package com.bawei.dingjianfei20200106.model.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者：丁建飞
 * 时间：2020/1/6  10:27
 * 类名：com.bawei.dingjianfei20200106.model.dao
 */
@Entity
public class Dao1  {
    private  String a;

    @Generated(hash = 1524718283)
    public Dao1(String a) {
        this.a = a;
    }

    @Generated(hash = 289743250)
    public Dao1() {
    }

    public String getA() {
        return this.a;
    }

    public void setA(String a) {
        this.a = a;
    }


}
