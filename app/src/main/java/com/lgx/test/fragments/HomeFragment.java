package com.lgx.test.fragments;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.lgx.test.MainActivity;
import com.lgx.test.R;
import com.lgx.test.base.BaseFragment;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


/**
 * Created by Harry on 2017/8/21.
 */

public class HomeFragment extends BaseFragment implements EasyPermissions.PermissionCallbacks{

    private static final int myTowPermission=560;
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
                checkPermission();
            }
        });

    }

    @Override
    protected void getData() {

    }

    @AfterPermissionGranted(myTowPermission)
    public void checkPermission(){
        String params[]={Manifest.permission.CAMERA, WRITE_EXTERNAL_STORAGE};
        if(EasyPermissions.hasPermissions(getActivity(),params)){
            startActivity(new Intent(getActivity(),MainActivity.class));
        }else{
            EasyPermissions.requestPermissions(this,"你还缺少权限",myTowPermission,params);
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this)
                    .setRationale("没有该权限，将不能打开ar视频。打开应用设置屏幕以修改应用权限")
                    .setTitle("必需权限")
                    .build()
                    .show();
        }
    }
}
