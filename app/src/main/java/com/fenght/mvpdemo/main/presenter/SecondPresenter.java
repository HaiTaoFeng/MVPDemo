package com.fenght.mvpdemo.main.presenter;

import com.fenght.mvpdemo.base.BasePresenter;
import com.fenght.mvpdemo.contract.SecondContract;
import com.fenght.mvpdemo.main.model.SecondModel;

public class SecondPresenter extends BasePresenter<SecondContract.ISecondView, SecondModel> implements SecondContract.ISecondPresenter{

    @Override
    public void handleData() {
        getView().showDailog();
        String a = getModel().requestData();
        getView().showMsg(a);
    }
}
