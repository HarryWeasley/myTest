package com.lgx.test.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by User on 2017/7/25.
 */

public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 获取布局ID
     */
    protected abstract int getContentViewLayoutID();

    /**
     * 初始化视图资源
     */
    protected abstract void initView();

    /**
     * Activity获取数据
     */
    protected abstract void getData();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentViewLayoutID() != 0) {
            setContentView(getContentViewLayoutID());
            initView();
            getData();
        }
    }
}
