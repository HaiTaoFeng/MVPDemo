package com.fenght.mvpdemo.contract;

import com.fenght.mvpdemo.base.IBasePresenter;
import com.fenght.mvpdemo.base.IBaseView;

public interface SecondContract {
    interface ISecondModel {
        String requestData();
    }

    interface ISecondView extends IBaseView {
        void showDailog();
        void showMsg(String msg);
    }

    interface ISecondPresenter extends IBasePresenter {
        void handleData();
    }
}
