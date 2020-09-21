package com.fenght.mvpdemo.http;

import com.fenght.mvpdemo.bean.BannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("banner/{type}")
    Observable<BannerBean> getBanner(@Path("type") String type);

}
