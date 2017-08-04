package com.lgx.test.fragments;

import android.os.Bundle;

import com.lgx.test.base.BaseFragment;

/**
 * Created by User on 2017/7/25.
 */

public class HomeFragment extends BaseFragment{

    public  static void newInstance(boolean isLazy) {
        Bundle bundle=new Bundle();
        bundle.putBoolean(BaseFragment.IS_LAZY,isLazy);
        HomeFragment homeFragment=new HomeFragment();
        homeFragment.setArguments(bundle);
    }

    @Override
    protected int getContentViewLayoutID() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {

    }
}
