package com.tear.sp.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @class name：com.tear.sp.base
 * @anthor Administrator
 * @time 2017/9/27 17:37
 * @class describe
 */

public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;
    protected View mContentView;
    protected Unbinder mUnbind;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            if (context != null) {
                mActivity = (BaseActivity) context;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            if (mContentView == null) {
                mContentView = LayoutInflater.from(mActivity).inflate(getLayoutID(), null);
                mUnbind = ButterKnife.bind(this, mContentView);
                initView(mContentView);
                setListeners();
            }
            if (mContentView.getParent() != null)
                ((ViewGroup) mContentView.getParent()).removeView(mContentView);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mContentView;
    }


    protected abstract int getLayoutID();

    protected abstract void initView(View mContentView);

    protected abstract void setListeners();

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbind.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
