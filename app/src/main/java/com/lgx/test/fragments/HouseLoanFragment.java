package com.lgx.test.fragments;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lgx.test.R;
import com.lgx.test.adapter.ViewPagerAdapter;
import com.lgx.test.base.BaseFragment;

/**
 * Created by Harry on 2017/8/21.
 */

public class HouseLoanFragment extends BaseFragment{
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_house_loan;
    }

    @Override
    protected void initView() {
        Toolbar toolbar= (Toolbar) rootView.findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
        Fragment[] fragments = {
                CommercialFragment.newInstance(false),
                new ReserveFundsFragment(),
                new MixedFragment()
        };
        String[] titles = {
                getString(R.string.commercial),
                getString(R.string.reserve_funds),
                getString(R.string.mixed)
        };
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), fragments, titles);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(viewPager.getAdapter().getCount());
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void getData() {

    }
}
