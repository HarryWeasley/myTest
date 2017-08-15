package com.lgx.test.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.lgx.test.R;

/**
 * Created by User on 2017/7/25.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar mToolBar;
    /**
     * 获取布局ID
     */
    protected abstract int getContentViewLayoutID();

    /**
     * 初始化视图资源
     */
    protected abstract void initView();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentViewLayoutID() != 0) {
            setContentView(getContentViewLayoutID());
            mToolBar= (Toolbar) findViewById(R.id.toolbar);
            if(mToolBar!=null){
                setSupportActionBar(mToolBar);
            }
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
            initView();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
