package com.bawei.dingjianfei20200106.netutil;

import com.bawei.dingjianfei20200106.model.bean.Bean;
import com.bawei.dingjianfei20200106.model.bean.BeanRight;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者：丁建飞
 * 时间：2020/1/6  9:07
 * 类名：com.bawei.dingjianfei20200106.netutil
 */

public interface Api {

    @GET("baweiapi/category")
    Observable<Bean> getBean();


    @GET("http://blog.zhaoliang5156.cn/baweiapi/shopByCategory?category=%E7%94%9F%E6%B4%BB")
    Observable<BeanRight> getBeanRight(@Query("category") String category);
}
