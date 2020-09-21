package com.fenght.mvpdemo.mvp.model;

import com.fenght.mvpdemo.base.BaseModel;
import com.fenght.mvpdemo.contract.MainContract;
import com.fenght.mvpdemo.http.ApiMethods;
import com.fenght.mvpdemo.http.ProgressObserver;

public class MainModel extends BaseModel implements MainContract.IMainModel {

    @Override
    public void requestData(String type,ProgressObserver progressObserver) {
        //请求数据
        ApiMethods.getBanner(type, progressObserver);
    }
}
