package com.fenght.mvpdemo.http;

import com.fenght.mvpdemo.bean.BannerBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 网络请求方法封装
 * @author fenghaitao
 * @time 2020年9月19日15:37:44
 */
public class ApiMethods {

    /**
     * 封装线程管理和订阅的过程
     */
    private static void ApiSubScribe(Observable observable, Observer observer) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 获取Banner数据
     *
     * @param type     类型
     * @param observer 由调用者传过来的观察者对象
     */
    public static void getBanner(String type, Observer<BannerBean> observer) {
        ApiSubScribe(Api.getApiService().getBanner(type), observer);
    }
}
