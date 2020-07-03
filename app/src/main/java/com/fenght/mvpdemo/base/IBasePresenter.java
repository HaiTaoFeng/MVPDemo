package com.fenght.mvpdemo.base;

public interface IBasePresenter<V extends IBaseView> {
    void attach(V v);
    void detach();
}
