package com.lgx.test.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.lgx.test.MainActivity;
import com.lgx.test.R;
import com.lgx.test.base.BaseFragment;

/**
 * Created by Harry on 2017/8/21.
 */

public class HomeFragment extends BaseFragment{
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        Button start= (Button) rootView.findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(),"测试",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getActivity(),MainActivity.class));
            }
        });

    }

    @Override
    protected void getData() {

    }
}
