package com.lgx.test.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by User on 2017/7/25.
 */

public abstract class BaseFragment extends Fragment{
    /**
     * 是否需要懒加载数据
     */
    public static final String IS_LAZY="is_lazy";

    protected View rootView;
    protected Unbinder unBinder;

    /**
     * 是否已经获取到数据
     */
    private boolean isFetchData = false;
    /**
     * 是否要懒加载数据
     */
    private boolean isLazy = true;

    /**
     * 获取布局ID
     */
    protected abstract int getContentViewLayoutID();

    /**
     * 初始化视图资源
     */
    protected abstract void initView();

    /**
     * fragment可见后，获取到数据
     */
    protected abstract void getData();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getContentViewLayoutID() != 0) {
            Bundle  bundle=getArguments();
            if(bundle!=null){
                isLazy=bundle.getBoolean(IS_LAZY,true);
            }
            rootView = inflater.inflate(getContentViewLayoutID(), container, false);
            unBinder = ButterKnife.bind(this, rootView);
            initView();
            return rootView;
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isLazy) {
            if (isVisibleToUser) {
                if (rootView == null | isFetchData) {
                    return;
                }
                isFetchData = true;
                getData();
            }
        }
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!isLazy) {
            getData();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unBinder != null) {
            unBinder.unbind();
        }
    }
}
