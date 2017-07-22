package com.lgx.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by User on 2017/7/22.
 */

public class VideoActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
    }

    @Override
    public void onBackPressed() {
        setResult(1);
//        super.onBackPressed();

        finish();
    }
}
