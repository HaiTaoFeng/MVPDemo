package com.fenght.mvpdemo.http;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

/**
 * 加载进度框
 * @author fenghaitao
 * @time 2020年9月19日15:52:36
 */
public class ProgressDialogHandler extends Handler {
    public static final int SHOW_PROGRESS_DIALOG = 1;  //显示加载框
    public static final int DISMISS_PROGRESS_DIALOG = 2;  //取消加载框

    private ProgressDialog pd;
    private Context context;
    private boolean isCancle;
    private ProgressCancleListener cancleListener;

    public ProgressDialogHandler(Context context,
                                 boolean isCancle, ProgressCancleListener cancleListener) {
        this.context = context;
        this.isCancle = isCancle;
        this.cancleListener = cancleListener;
    }

    //初始化加载框并展示
    private void initProgressDialog(){
        if (pd == null) {
            pd = new ProgressDialog(context);
            pd.setCancelable(isCancle);
            if (isCancle) {
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        //取消加载框（作用：取消的同时，把请求的订阅也取消）
                        cancleListener.cancle();
                    }
                });
            }

            if (!pd.isShowing()) {
                pd.show();
            }
        }
    }

    //取消加载框
    private void dismissProgressDialog(){
        if (pd != null) {
            pd.dismiss();
            pd = null;
        }
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        switch (msg.what){
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }

    //取消监听接口
    interface ProgressCancleListener{
        void cancle();
    }
}
