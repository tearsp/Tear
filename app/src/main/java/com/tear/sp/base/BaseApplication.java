package com.tear.sp.base;

import android.app.Application;

/**
 * @class name：com.tear.sp.base
 * @anthor Administrator
 * @time 2017/9/27 15:45
 * @class describe
 */

public class BaseApplication extends Application {
    private static BaseApplication mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }

    public static BaseApplication getInstance() {
        return BaseApplication.mApp;
    }
}
