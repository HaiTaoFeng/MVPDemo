package com.fenght.mvpdemo.mvp.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fenght.mvpdemo.R;
import com.fenght.mvpdemo.base.BaseActivity;
import com.fenght.mvpdemo.bean.BannerBean;
import com.fenght.mvpdemo.contract.MainContract;
import com.fenght.mvpdemo.inject.InjectPresenter;
import com.fenght.mvpdemo.mvp.presenter.MainPresenter;

import java.util.List;

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
    public void succesData(BannerBean bannerBean) {
        tv_text.setText("请求成功！");
        List<BannerBean.DataBean> list = bannerBean.getData();
        for (BannerBean.DataBean dataBean:list) {
            Log.e("fht","数据" + dataBean.getTitle());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_text:
                break;
        }
    }
}
