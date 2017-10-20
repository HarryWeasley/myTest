package com.lgx.test.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import com.lgx.test.R;
import com.lgx.test.adapter.FragmentAdapter;
import com.lgx.test.base.BaseActivity;
import com.lgx.test.fragments.CompanyFragment;
import com.lgx.test.fragments.HomeFragment;
import com.lgx.test.fragments.HouseLoanFragment;
import com.lgx.test.fragments.LocalFragment;

/**
 * Created by Harry on 2017/7/25.
 */

public class HomeActivity extends BaseActivity {
    private TabLayout mTablayout;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        mTablayout = (TabLayout) findViewById(R.id.bottom_tabs);
        setSupportActionBar(toolbar);
        toolbar.setTitle("首页");
        initTab();
        initFragments();
    }

    private void initTab() {
        String[] titles = {getString(R.string.app_name),
                getString(R.string.vr_model),
                getString(R.string.price),
                getString(R.string.company)};
        for (int i = 0; i < titles.length; i++) {
            TabLayout.Tab tab=mTablayout.newTab().setText(titles[i]);
            mTablayout.addTab(tab);
        }

    }

    private void initFragments() {
        Fragment[] fragments = {new CompanyFragment(),new HomeFragment(), new HouseLoanFragment(), new LocalFragment()};
        final FragmentAdapter myAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments, R.id.contentLayout);
        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                myAdapter.showFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}
