package com.fenght.mvpdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.fenght.mvpdemo.inject.InjectPresenter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements IBaseView{

    //保存使用注解的presenter，用于解绑
    private List<BasePresenter> mInjectPresenters;

    protected abstract void initLayout(@Nullable Bundle savedInstanceState);

    protected abstract void initViews();
    protected abstract void initData();
    protected <T extends View> T $(@IdRes int viewId){
        return findViewById(viewId);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout(savedInstanceState);
        //实例化和绑定P层
        mInjectPresenters = new ArrayList<>();
        //获得已经声明的变量，包括私有的
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field:fields) {
            //获取变量上面的注解类型
            InjectPresenter injectPresenter = field.getAnnotation(InjectPresenter.class);
            //有变量添加InjectPresenter注解
            if (injectPresenter != null) {
                try{
                    Class<? extends BasePresenter> type = (Class<? extends BasePresenter>) field.getType();
                    BasePresenter mInjectPresenter = type.newInstance();//实例化presenter
                    mInjectPresenter.attach(this); //绑定view
                    field.setAccessible(true); //属性设置为可以被外部访问
                    field.set(this,mInjectPresenter);
                    mInjectPresenters.add(mInjectPresenter);
                }catch (IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }catch (ClassCastException e){
                    e.printStackTrace();
                    throw new RuntimeException("SubClass must extends Class:BasePresenter");
                }
            }
        }

        initViews();
        initData();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        for (BasePresenter presenter: mInjectPresenters){
            presenter.detach();
        }
        mInjectPresenters.clear();
        mInjectPresenters = null;
    }

    @Override
    public Context getContext() {
        return this;
    }
}
