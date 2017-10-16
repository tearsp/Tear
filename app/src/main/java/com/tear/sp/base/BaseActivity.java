package com.tear.sp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tear.sp.utils.AppManager;

import butterknife.ButterKnife;

/**
 * @class name：com.tear.sp.base
 * @anthor Administrator
 * @time 2017/9/27 15:46
 * @class describe
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected BaseActivity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            mActivity = this;
            AppManager.getInstance().addActivity(this);
            setContentView(getLayoutId());
            ButterKnife.bind(this);
            initView();
            setListeners();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void setListeners();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().removeActivityByTag(this);

    }

}
