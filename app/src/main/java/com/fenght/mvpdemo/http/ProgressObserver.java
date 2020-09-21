package com.fenght.mvpdemo.http;

import android.content.Context;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ProgressObserver<T> implements Observer<T>,
        ProgressDialogHandler.ProgressCancleListener {

    private ObserverListener observerListener; //数据监听回调
    private ProgressDialogHandler progressDialogHandler;
    private Context context;
    private Disposable d; //订阅事件


    public ProgressObserver(ObserverListener observerListener, Context context) {
        this.observerListener = observerListener;
        this.context = context;
        progressDialogHandler = new ProgressDialogHandler(context,true,this);
    }

    //显示加载框 1为显示，2为取消
    private void showProgeressDialog(int isShow){
        if (progressDialogHandler != null) {
            progressDialogHandler.obtainMessage(isShow).sendToTarget();
        }
    }

    @Override
    public void cancle() {
        //如果处于订阅状态，则取消订阅
        if (d != null) {
            d.dispose();
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.d = d;
        showProgeressDialog(ProgressDialogHandler.SHOW_PROGRESS_DIALOG);
    }

    @Override
    public void onNext(T t) {
        observerListener.OnNext(t);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {
        showProgeressDialog(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG);
    }
}
