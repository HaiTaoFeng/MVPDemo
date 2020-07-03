package com.fenght.mvpdemo.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fenght.mvpdemo.R;
import com.fenght.mvpdemo.base.BaseActivity;
import com.fenght.mvpdemo.contract.MainContract;
import com.fenght.mvpdemo.inject.InjectPresenter;
import com.fenght.mvpdemo.main.presenter.MainPresenter;

import androidx.annotation.Nullable;


public class MainActivity extends BaseActivity implements MainContract.IMainView, View.OnClickListener {
    @InjectPresenter
    private MainPresenter mainPresenter; //通过注解进行实例化
    private TextView tv_text;

    @Override
    protected void initLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initViews() {
        tv_text = $(R.id.tv_text);
        tv_text.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mainPresenter.handleData();
    }


    @Override
    public void showDialog() {
        Toast.makeText(MainActivity.this,"开始获取数据",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void succesMsg() {
        tv_text.setText("请求成功！");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_text:
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
                break;
        }
    }
}
