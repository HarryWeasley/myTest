package com.lgx.test.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.lgx.test.R;
import com.lgx.test.base.BaseActivity;

/**
 * Created by Harry on 2017/9/11.
 */

public class FollowUsActivity extends BaseActivity{


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_follow_us;
    }

    @Override
    protected void initView() {
        TextView dial= (TextView) findViewById(R.id.dial);
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "08252281118"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}
