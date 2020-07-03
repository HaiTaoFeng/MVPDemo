package com.fenght.mvpdemo.main.model;

import com.fenght.mvpdemo.base.BaseModel;
import com.fenght.mvpdemo.contract.MainContract;

public class MainModel extends BaseModel implements MainContract.IMainModel {


    @Override
    public void requestData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
