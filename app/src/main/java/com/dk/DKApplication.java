package com.dk;

import android.app.Application;


/**
 * Created by ${chenyn} on 2017/10/9.
 */

public class DKApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        SMSSDK.getInstance().initSdk(this);
//        SMSSDK.getInstance().setIntervalTime(30*1000);//设置前后两次获取验证码的时间间隔，默认也是 30 秒。
    }
}
