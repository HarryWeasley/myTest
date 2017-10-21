package com.lgx.test.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
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
        ImageView imageView= (ImageView) findViewById(R.id.image);
        CollapsingToolbarLayout collapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        ViewCompat.setTransitionName(imageView,Constants.DESCRIPTION_IMAGE);
        String str = getIntent().getStringExtra(Constants.VIRTUAL_DESCRIPTION);
        switch (str) {
            case Constants.CHINA_BAOLI:
                collapsingToolbarLayout.setTitle("中国保利");
                description.setText(getString(R.string.china_baoli));
                break;
            case Constants.BAOLI_COMPANY:
                collapsingToolbarLayout.setTitle("保利地产");
                description.setText(getString(R.string.baoli_company));
                break;
            case Constants.BAOLI_CHENGDU:
                collapsingToolbarLayout.setTitle("保利成都");
                description.setText(getString(R.string.baoli_chengdu));
                break;
        }
//        collapsingToolbarLayout.setExpandedTitleColor(Color.GREEN);
//        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.BLACK);
    }

}
