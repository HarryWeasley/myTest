package com.lgx.test.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.lgx.test.R;
import com.lgx.test.base.BaseActivity;
import com.lgx.test.fragments.CompanyFragment;
import com.lgx.test.fragments.HomeFragment;
import com.lgx.test.fragments.HouseLoanFragment;
import com.lgx.test.fragments.LocalFragment;

/**
 * Created by Harry on 2017/7/25.
 */

public class HomeActivity extends BaseActivity {


    public static final String ITEM_HOME = "VR模型";
    public static final String ITEM_PRICE = "房贷助手";
    public static final String ITEM_LOCAL = "保利养生谷";
    public static final String ITEM_COMPANY = "保利品牌";
    private FragmentManager mFragmentManager;
    private String currentFragmentTag;
    private DrawerLayout mDrawerLayout;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        mFragmentManager = getSupportFragmentManager();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        setSupportActionBar(toolbar);
        //设置抽屉DrawerLayout
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();//初始化状态
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                item.setChecked(true);
                switch (item.getItemId()) {
                    case R.id.item_home:
                        switchContent(ITEM_HOME);
                        break;
                    case R.id.item_company:
                        switchContent(ITEM_COMPANY);
                        break;
                    case R.id.item_local:
                        switchContent(ITEM_LOCAL);
                        break;
                    case R.id.item_price:
                        switchContent(ITEM_PRICE);
                        break;

                }
                return false;
            }
        });
        switchContent(ITEM_LOCAL);
    }

    private void switchContent(String tagName) {
        if (currentFragmentTag != null && currentFragmentTag.equals(tagName)) {
            return;
        }
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        Fragment currentFragment = mFragmentManager.findFragmentByTag(currentFragmentTag);
        if (currentFragment != null) {
            ft.hide(currentFragment);
        }
        Fragment findFragment = mFragmentManager.findFragmentByTag(tagName);
        if (findFragment == null) {
            switch (tagName) {
                case ITEM_HOME:
                    findFragment = new HomeFragment();
                    break;
                case ITEM_COMPANY:
                    findFragment = new CompanyFragment();
                    break;
                case ITEM_LOCAL:
                    findFragment=new LocalFragment();
                    break;
                case ITEM_PRICE:
                    findFragment=new HouseLoanFragment();
                    break;
            }
        }
        if (findFragment.isAdded()) {
            ft.show(findFragment);
        } else {
            ft.add(R.id.contentLayout, findFragment, tagName);
        }
        getSupportActionBar().setTitle(tagName);

        ft.commit();
        currentFragmentTag = tagName;
    }
}
