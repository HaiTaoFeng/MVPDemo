package com.fenght.mvpdemo.http;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 封装实现Observer方法，只监听onNext和onError方法
 * @author fenghaitao
 * @time 2020年9月23日13:47:34
 * @param <T>
 */
public class BaseObserver<T> implements Observer<T> {

    private static final String TAG = "BaseObserver";
    private ObserverListener observerListener;

    public BaseObserver(ObserverListener observerListener) {
        this.observerListener = observerListener;
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.e(TAG,"onSubscribe>>>");
    }

    @Override
    public void onNext(T t) {
        observerListener.OnNext(t);
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG,"onError>>>" + e.getMessage());
        observerListener.onError(e.getMessage());
    }

    @Override
    public void onComplete() {
        Log.e(TAG,"onComplete>>>");
    }
}
