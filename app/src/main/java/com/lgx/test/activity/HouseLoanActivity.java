package com.lgx.test.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.lgx.test.R;
import com.lgx.test.base.BaseActivity;
import com.lgx.test.common.ViewPagerAdapter;
import com.lgx.test.fragments.CommercialFragment;
import com.lgx.test.fragments.MixedFragment;
import com.lgx.test.fragments.ReserveFundsFragment;

/**
 * Created by Harry on 2017/8/7.
 */

public class HouseLoanActivity extends BaseActivity {

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_house_loan;
    }

    @Override
    protected void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
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
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(viewPager.getAdapter().getCount());
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void getData() {

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
