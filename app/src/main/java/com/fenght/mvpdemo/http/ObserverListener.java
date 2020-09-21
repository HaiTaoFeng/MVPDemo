package com.fenght.mvpdemo.http;

/**
 *观察者OnNext方法监听
 * @author fenghaitao
 * @time 2020年9月18日20:28:14
 */
public interface ObserverListener<T> {
   void OnNext(T t);
}
