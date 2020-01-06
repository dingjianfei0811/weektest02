package com.bawei.dingjianfei20200106.netutil;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：丁建飞
 * 时间：2020/1/6  9:13
 * 类名：com.bawei.dingjianfei20200106.netutil
 */
public class NetUtil  {

    private final Api api;

    private  static  final  class  Qaa{
        private  static  NetUtil netUtil=new NetUtil();
    }

    String Http="http://blog.zhaoliang5156.cn/";
    private NetUtil() {
        //日志
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit build = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Http)
                .client(okHttpClient)
                .build();
        api = build.create(Api.class);

    }

    public Api getApi() {
        return api;
    }


    public static NetUtil getInstance() {
        return Qaa.netUtil;
    }
    public  boolean wWang(Context context){
        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo != null&&activeNetworkInfo.isAvailable()) {
            return  true;
        }else {
            return false;
        }
    }

}
