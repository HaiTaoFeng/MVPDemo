package com.fenght.mvpdemo.http;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

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
    }

    @Override
    public void onComplete() {
        Log.e(TAG,"onComplete>>>");
    }
}
