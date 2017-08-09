package com.lgx.test.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Harry on 2017/8/8.
 */

public class FragmentAdapter {
    private FragmentManager mFragmentManager;
    private Fragment[] mFragments;

    public FragmentAdapter(FragmentManager fragmentManager,Fragment[] fragments,int contentId){
        mFragmentManager=fragmentManager;
        mFragments=fragments;
        FragmentTransaction fragmentTransaction=mFragmentManager.beginTransaction();
        for(Fragment fragment:fragments){
            fragmentTransaction.add(contentId,fragment);
        }
        fragmentTransaction.commit();
        showFragment(0);
    }

    public void showFragment(int position){
        FragmentTransaction transaction=mFragmentManager.beginTransaction();
        for (int i=0;i<mFragments.length;i++){
            if(i==position){
                mFragments[i].setUserVisibleHint(true);
                transaction.show(mFragments[i]);
            }else{
                mFragments[i].setUserVisibleHint(false);
                transaction.hide(mFragments[i]);
            }
        }

    }
}
