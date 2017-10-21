package com.lgx.test.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lgx.test.R;
import com.lgx.test.base.BaseActivity;
import com.lgx.test.common.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Harry on 2017/8/10.
 */

public class LocalDescriptionActivity extends BaseActivity {
    @BindView(R.id.image_toolbar)
    ImageView mImageToolbar;
    @BindView(R.id.image_top)
    ImageView mImageTop;
    @BindView(R.id.image_medium)
    ImageView mImageMedium;
    @BindView(R.id.image_bottom)
    ImageView mImageBottom;
    @BindView(R.id.image_bottom2)
    ImageView mImageBottom2;
    @BindView(R.id.collapsing)
    CollapsingToolbarLayout mCollapsing;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    Unbinder mUnBinder;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_local_description;
    }

    @Override
    protected void initView() {
        mUnBinder= ButterKnife.bind(this);

        Glide.with(this).load(R.mipmap.local_baoli).into(mImageToolbar);
        ViewCompat.setTransitionName(mImageToolbar, Constants.DESCRIPTION_IMAGE);
        Glide.with(this).load(R.mipmap.medium).into(mImageTop);
        Glide.with(this).load(R.mipmap.image_one).into(mImageMedium);
        Glide.with(this).load(R.mipmap.bottom).into(mImageBottom);
        Glide.with(this).load(R.mipmap.bottom2).into(mImageBottom2);

//        mCollapsing.setExpandedTitleColor(Color.GREEN);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "08252281118"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }
}
