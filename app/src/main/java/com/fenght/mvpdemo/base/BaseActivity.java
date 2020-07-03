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
//    private P mPresenter;
    //保存使用注解的presenter，用于解绑
    private List<BasePresenter> mInjectPresenters;

    protected abstract void initLayout(@Nullable Bundle savedInstanceState);

    protected abstract void initViews();
    protected abstract void initData();
//    protected abstract P setPresenter();
    protected <T extends View> T $(@IdRes int viewId){
        return findViewById(viewId);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout(savedInstanceState);
        //实例化和绑定P层
//        mPresenter = setPresenter();
//        if (mPresenter != null) {
//            mPresenter.attach(this);
//        }
        mInjectPresenters = new ArrayList<>();
        //获得已经声明的变量，包括私有的
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field:fields) {
            //获取变量上面的注解类型
            InjectPresenter injectPresenter = field.getAnnotation(InjectPresenter.class);
            if (injectPresenter != null) {
                try{
                    Class<? extends BasePresenter> type = (Class<? extends BasePresenter>) field.getType();
                    BasePresenter mInjectPresenter = type.newInstance();//实例化presenter
                    mInjectPresenter.attach(this); //绑定view
                    field.setAccessible(true);
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
