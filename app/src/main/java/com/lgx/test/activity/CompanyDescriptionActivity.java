package com.lgx.test.activity;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.lgx.test.R;
import com.lgx.test.base.BaseActivity;
import com.lgx.test.common.Constants;

/**
 * Created by Harry on 2017/8/9.
 */

public class CompanyDescriptionActivity extends BaseActivity {
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_description;
    }

    @Override
    protected void initView() {
        TextView description = (TextView) findViewById(R.id.text_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        ImageView imageView= (ImageView) findViewById(R.id.image);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ViewCompat.setTransitionName(imageView,Constants.DESCRIPTION_IMAGE);
        String str = getIntent().getStringExtra(Constants.VIRTUAL_DESCRIPTION);
        switch (str) {
            case Constants.CHINA_BAOLI:
                description.setText(getString(R.string.china_baoli));
                break;
            case Constants.BAOLI_COMPANY:
                description.setText(getString(R.string.baoli_company));
                break;
            case Constants.BAOLI_CHENGDU:
                description.setText(getString(R.string.baoli_chengdu));
                break;

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
