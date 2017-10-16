package com.tear.sp;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tear.sp.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.tv_main)
    TextView tv_main;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListeners() {
        tv_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity, "Bind", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.tv_main)
    public void onClick(View view) {

    }
}
