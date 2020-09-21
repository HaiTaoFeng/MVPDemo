package com.fenght.mvpdemo.mvp.presenter;

import android.util.Log;

import com.fenght.mvpdemo.App;
import com.fenght.mvpdemo.base.BasePresenter;
import com.fenght.mvpdemo.base.IBaseView;
import com.fenght.mvpdemo.bean.BannerBean;
import com.fenght.mvpdemo.contract.MainContract;
import com.fenght.mvpdemo.http.ApiMethods;
import com.fenght.mvpdemo.http.ObserverListener;
import com.fenght.mvpdemo.http.ProgressObserver;
import com.fenght.mvpdemo.mvp.model.MainModel;

import java.util.List;

/**
 * presenter 层，承担业务逻辑处理，数据源处理等
 * @author fht
 */
public class MainPresenter extends BasePresenter<MainContract.IMainView, MainModel> implements MainContract.IMainPresenter {
    private MainContract.IMainModel mModel;

    @Override
    public void attach(IBaseView iBaseView) {
        super.attach(iBaseView);
        mModel = new MainModel();
    }

    @Override
    public void detach() {
        super.detach();
    }

    @Override
    public void handleData() {
        getView().showDialog();
        ObserverListener<BannerBean> observerListener = new ObserverListener<BannerBean>() {
            @Override
            public void OnNext(BannerBean bannerBean) {
                Log.e("fht","onNext");
                //将数据传到Activity
                getView().succesData(bannerBean);
            }
        };
        getModel().requestData("json",new ProgressObserver(observerListener,getView().getContext()));
    }
}
