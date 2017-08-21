package com.lgx.test.fragments;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.lgx.test.R;
import com.lgx.test.base.BaseFragment;

/**
 * Created by Harry on 2017/8/7.
 */

public class FollowUsFragment extends BaseFragment{


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_follow_us;
    }

    @Override
    protected void initView() {
        TextView dial= (TextView) rootView.findViewById(R.id.dial);
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "08252281118"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void getData() {

    }
}
