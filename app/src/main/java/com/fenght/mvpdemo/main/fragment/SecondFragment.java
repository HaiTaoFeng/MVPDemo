package com.fenght.mvpdemo.main.fragment;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.fenght.mvpdemo.R;
import com.fenght.mvpdemo.base.BaseFragment;
import com.fenght.mvpdemo.contract.SecondContract;
import com.fenght.mvpdemo.inject.InjectPresenter;
import com.fenght.mvpdemo.main.presenter.SecondPresenter;

import androidx.annotation.Nullable;

public class SecondFragment extends BaseFragment implements SecondContract.ISecondView {
    private TextView tv_text;

    @InjectPresenter
    private SecondPresenter mSecondPresenter;


    @Override
    protected int setLayout() {
        return R.layout.fragment_second;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        tv_text = $(R.id.tv_text);
    }

    @Override
    protected void initData() {
        mSecondPresenter.handleData();
    }

    @Override
    public void showDailog() {
        Toast.makeText(getActivity(),"开始fragment请求",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMsg(String msg) {
        tv_text.setText(msg);
    }

}
