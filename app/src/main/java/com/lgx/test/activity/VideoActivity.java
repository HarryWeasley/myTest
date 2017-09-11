package com.lgx.test.activity;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.VideoView;

import com.lgx.test.MainActivity;
import com.lgx.test.R;

/**
 * Created by User on 2017/7/22.
 */

public class VideoActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        VideoView videoView= (VideoView) findViewById(R.id.video_view);
        String video_url=getIntent().getStringExtra(MainActivity.VIDEO_URL);
        String url="android.resource://"+getPackageName()+"/"+ R.raw.description;
        if(MainActivity.OVER_VIEW.equals(video_url)){
            url="android.resource://"+getPackageName()+"/"+ R.raw.overview;
        }
        videoView.setVideoURI(Uri.parse(url));
        videoView.start();
    }

    @Override
    public void onBackPressed() {
        setResult(1);
        finish();
    }

    @Override
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(new ContextWrapper(newBase)
        {
            @Override
            public Object getSystemService(String name)
            {
                if (Context.AUDIO_SERVICE.equals(name))
                    return getApplicationContext().getSystemService(name);
                return super.getSystemService(name);
            }
        });
    }
}
