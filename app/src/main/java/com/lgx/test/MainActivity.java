package com.lgx.test;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.lgx.test.activity.VideoActivity;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class MainActivity extends UnityPlayerActivity {

    FrameLayout ll;
    ProgressBar mProgressBar;
    public static final String VIDEO_URL="video_url";
    public static final String OVER_VIEW="over_view";
    public static final String DESCRIPTION="description";
    public static final int OVER_VIEW_INT=2;
    public static final int DESCRIPTION_INT=3;
    private MyTask mMyTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = (FrameLayout) findViewById(R.id.view);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        ll.addView(mUnityPlayer.getView());
        mMyTask = new MyTask();
        mMyTask.execute();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMyTask.cancel(true);
    }

    public void startVideoActivity(String ulr) {
        Intent intent = new Intent(this, VideoActivity.class);
        if("overview".equals(ulr)){
            intent.putExtra(VIDEO_URL,OVER_VIEW);
            startActivityForResult(intent, OVER_VIEW_INT);
        }else{
            intent.putExtra(VIDEO_URL,DESCRIPTION);
            startActivityForResult(intent, DESCRIPTION_INT);
        }


    }

    @Override
    public void onBackPressed() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mUnityPlayer.quit();
            }
        });
        super.onBackPressed();
    }


    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(requestCode==DESCRIPTION_INT){
                                UnityPlayer.UnitySendMessage("start", "setFirstTrue", "");
                            }else{
                                UnityPlayer.UnitySendMessage("startOverView", "setFirstTrueOverView", "");
                            }

                        }
                    });
                }
            }).start();

        }

    }


    private class MyTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mProgressBar.setVisibility(View.GONE);

        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }


}
