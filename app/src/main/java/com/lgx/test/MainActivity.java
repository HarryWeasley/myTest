package com.lgx.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.lgx.test.activity.VideoActivity;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class MainActivity extends UnityPlayerActivity {

    LinearLayout  ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll= (LinearLayout) findViewById(R.id.frame);

        Button btn= (Button) findViewById(R.id.click);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ll.addView(mUnityPlayer);
                mUnityPlayer.quit();
            }
        });

    }





    public void startVideoActivity(String ulr){
        Log.i("tag","测试成功了"+ulr);
        Intent intent=new Intent(this,VideoActivity.class);
        startActivityForResult(intent,0);

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            mUnityPlayer.quit();
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
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
                            UnityPlayer.UnitySendMessage("start","setFirstTrue","");
                        }
                    });
                }
            }).start();

        }

    }


}
