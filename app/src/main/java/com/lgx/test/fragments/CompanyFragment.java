package com.lgx.test.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lgx.test.R;
import com.lgx.test.activity.CompanyDescriptionActivity;
import com.lgx.test.base.BaseFragment;
import com.lgx.test.common.Constants;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Harry on 2017/8/7.
 */

public class CompanyFragment extends BaseFragment {


    @BindView(R.id.label)
    ImageView mLabel;
    @BindView(R.id.china_baoli)
    TextView mChinaBaoli;
    @BindView(R.id.baoli_company)
    TextView mBaoliCompany;
    @BindView(R.id.baoli_chengdu)
    TextView mBaoliChengdu;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_company;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void getData() {

    }


    @OnClick({R.id.china_baoli, R.id.baoli_company, R.id.baoli_chengdu})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.china_baoli:
                Intent intent = new Intent(getActivity(), CompanyDescriptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.VIRTUAL_DESCRIPTION, Constants.CHINA_BAOLI);
                intent.putExtras(bundle);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), mLabel, Constants.DESCRIPTION_IMAGE);
                ActivityCompat.startActivity(getActivity(), intent, optionsCompat.toBundle());
                break;
            case R.id.baoli_company:
                Intent intentCompany = new Intent(getActivity(), CompanyDescriptionActivity.class);
                Bundle bundleCompany = new Bundle();
                bundleCompany.putString(Constants.VIRTUAL_DESCRIPTION, Constants.BAOLI_COMPANY);
                intentCompany.putExtras(bundleCompany);
                ActivityOptionsCompat optionsCompatCompany = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), mLabel, Constants.DESCRIPTION_IMAGE);
                ActivityCompat.startActivity(getActivity(), intentCompany, optionsCompatCompany.toBundle());
                break;
            case R.id.baoli_chengdu:
                Intent intentChengdu = new Intent(getActivity(), CompanyDescriptionActivity.class);
                Bundle bundleChengdu = new Bundle();
                bundleChengdu.putString(Constants.VIRTUAL_DESCRIPTION, Constants.BAOLI_CHENGDU);
                intentChengdu.putExtras(bundleChengdu);
                ActivityOptionsCompat optionsCompatChengdu = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), mLabel, Constants.DESCRIPTION_IMAGE);
                ActivityCompat.startActivity(getActivity(), intentChengdu, optionsCompatChengdu.toBundle());
                break;
        }
    }
}
