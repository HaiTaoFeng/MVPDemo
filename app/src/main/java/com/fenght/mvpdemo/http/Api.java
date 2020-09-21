package com.fenght.mvpdemo.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Api {
    //基础域名
    private static String baseUrl = "https://www.wanandroid.com/";

    private volatile static ApiService apiService = null;
    //获取单例
    public static ApiService getApiService(){
        if (apiService == null) {
            synchronized (Api.class){
                if (apiService == null) {
                    new Api();
                }
            }
        }
        return apiService;
    }


    private Api(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create()) //请求结果转换为基本数据类型
                .addConverterFactory(GsonConverterFactory.create()) //请求结果转换为实体类
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //适配RxJava2.0
                .build();
        apiService = retrofit.create(ApiService.class);
    }
}
