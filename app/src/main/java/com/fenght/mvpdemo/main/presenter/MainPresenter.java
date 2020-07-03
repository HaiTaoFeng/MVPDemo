package com.fenght.mvpdemo.main.presenter;

import com.fenght.mvpdemo.base.BasePresenter;
import com.fenght.mvpdemo.base.IBaseView;
import com.fenght.mvpdemo.contract.MainContract;
import com.fenght.mvpdemo.main.model.MainModel;

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
        mModel.requestData();
        getView().succesMsg();
    }
}
