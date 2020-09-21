package com.fenght.mvpdemo.mvp.model;

import com.fenght.mvpdemo.base.BaseModel;
import com.fenght.mvpdemo.contract.SecondContract;

public class SecondModel extends BaseModel implements SecondContract.ISecondModel {
    @Override
    public String requestData() {
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
        return "请求失败";
    }
}
