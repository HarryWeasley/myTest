package com.lgx.test.fragments;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lgx.test.R;
import com.lgx.test.activity.FollowUsActivity;
import com.lgx.test.activity.LocalDescriptionActivity;
import com.lgx.test.activity.TypePresentationActivity;
import com.lgx.test.base.BaseFragment;
import com.lgx.test.common.Constants;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Harry on 2017/8/10.
 */

public class LocalFragment extends BaseFragment {

    @BindView(R.id.label)
    ImageView mLabel;
    @BindView(R.id.project_overview)
    TextView mProjectOverview;
    @BindView(R.id.type_presentation)
    TextView mTypePresentation;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_local;
    }

    @Override
    protected void initView() {
        Glide.with(getActivity()).load(R.mipmap.local_baoli).into(mLabel);

    }

    @Override
    protected void getData() {

    }

    @OnClick({R.id.project_overview, R.id.type_presentation,R.id.follow_us})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.project_overview:
                ActivityOptionsCompat optionsCompatCompany = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), mLabel, Constants.DESCRIPTION_IMAGE);
                ActivityCompat.startActivity(getActivity(), new Intent(getActivity(), LocalDescriptionActivity.class), optionsCompatCompany.toBundle());
                break;
            case R.id.type_presentation:
                startActivity(new Intent(getActivity(), TypePresentationActivity.class));
                break;
            case R.id.follow_us:
                startActivity(new Intent(getActivity(), FollowUsActivity.class));
                break;
        }
    }
}
