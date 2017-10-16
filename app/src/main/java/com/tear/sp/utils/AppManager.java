package com.tear.sp.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * @class name：com.tear.sp.utils
 * @anthor Administrator
 * @time 2017/9/27 16:07
 * @class acticity栈管理
 */

public class AppManager {
    public final static Stack<Activity> mActivityStack = new Stack<>();

    private AppManager() {
    }

    private static class InnerAppManager {
        private static AppManager instance = new AppManager();
    }

    public static AppManager getInstance() {
        return InnerAppManager.instance;
    }

    public void addActivity(Activity activity) {
        mActivityStack.add(activity);
    }

    public void removeActivityByTag(Activity activity) {
        if (mActivityStack.contains(activity)) {
            mActivityStack.remove(activity);
        }
    }

    public void finishByClassName(Class<?> cls) {
        for (Activity activity : mActivityStack) {
            if (activity.getClass().equals(cls) && !activity.isFinishing()) {
                mActivityStack.remove(activity);
                activity.finish();
            }
        }
    }

    public void finishAllActivity() {
        for (Activity activity : mActivityStack) {
            activity.finish();
        }
        mActivityStack.clear();
    }
}
