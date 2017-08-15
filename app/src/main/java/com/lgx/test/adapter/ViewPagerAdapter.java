package com.lgx.test.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Harry on 2017/8/8.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] mFragments;
    private String [] mStrings;

    public ViewPagerAdapter(FragmentManager fm, Fragment[] mFragments, String [] mStrings) {
        super(fm);
        this.mFragments=mFragments;
        this.mStrings=mStrings;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mStrings[position];
    }
}
