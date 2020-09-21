package com.fenght.mvpdemo.contract;

import com.fenght.mvpdemo.base.IBasePresenter;
import com.fenght.mvpdemo.base.IBaseView;
import com.fenght.mvpdemo.bean.BannerBean;
import com.fenght.mvpdemo.http.ProgressObserver;

/**
 * @author fht
 * 契约接口，可以很直观的看到 M、V、P 层接口中提供的方法
 */
public interface MainContract {
    interface IMainModel{
        void requestData(String type, ProgressObserver progressObserver);
    }

    interface IMainView extends IBaseView {
        void showDialog();
        void succesData(BannerBean bannerBean);
        void errorMsg(String msg);
    }

    interface IMainPresenter extends IBasePresenter {
        void handleData();
    }
}
