package com.lgx.test.activity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lgx.test.R;
import com.lgx.test.adapter.HouseType;
import com.lgx.test.base.BaseActivity;
import com.lgx.test.common.Constants;
import com.lgx.test.weights.PinchImageView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Harry on 2017/8/15.
 */

public class RealHouseTypeActivity extends BaseActivity {

    private int[] ids = {R.mipmap.a1_type, R.mipmap.a1_type2};
    private List<Integer> imageList = new ArrayList<>();

    private LinkedList<PinchImageView> viewCache = new LinkedList<>();

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_real_house;
    }

    @Override
    protected void initView() {

        HouseType houseType = getIntent().getParcelableExtra(Constants.HOUSE_TYPE);

        CardView cardView = (CardView) findViewById(R.id.card_view);
        ViewCompat.setTransitionName(cardView, Constants.DESCRIPTION_IMAGE);
        TextView title = (TextView) findViewById(R.id.title);
        TextView content = (TextView) findViewById(R.id.content);
        title.setText(houseType.getTypeName());
        content.setText(String.format("产权面积约%s平米，赠送面积约%s平米", houseType.getRealArea(),
                houseType.getGivenArea()));

        initData(houseType.getTypeName());


        final ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                PinchImageView piv;
                if (viewCache.size() > 0) {
                    piv = viewCache.remove();
                    piv.reset();
                } else {
                    piv = new PinchImageView(RealHouseTypeActivity.this);
                }
                Glide.with(RealHouseTypeActivity.this).load(ids[position]).into(piv);
                container.addView(piv);
                piv.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Toast.makeText(RealHouseTypeActivity.this, "这里进行了点击", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                return piv;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                PinchImageView piv = (PinchImageView) object;
                container.removeView(piv);
                viewCache.add(piv);
            }

        });
    }

    private void initData(String typeName) {
        if (imageList.size() != 0) {
            imageList.clear();
        }
        switch (typeName) {
            case "A1户型":
                imageList.add(R.mipmap.a1_type);
                imageList.add(R.mipmap.a1_type2);
                break;
            case "A2户型":
                imageList.add(R.mipmap.a2_type);
                imageList.add(R.mipmap.a2_type2);
                break;
            case "A3户型":
                imageList.add(R.mipmap.a3_type);
                imageList.add(R.mipmap.a3_type2);
                break;
            case "B1户型":
                imageList.add(R.mipmap.b1_type);
                imageList.add(R.mipmap.b1_type2);
                break;
            case "B2户型":
                imageList.add(R.mipmap.b2_type);
                imageList.add(R.mipmap.b2_type2);
                break;
            case "B3户型":
                imageList.add(R.mipmap.b3_type);
                imageList.add(R.mipmap.b3_type2);
                break;
            case "C1户型":
                imageList.add(R.mipmap.c1_type);
                imageList.add(R.mipmap.c1_type2);
                break;
            case "D1户型":
                imageList.add(R.mipmap.d1_type);
                break;
            case "D2户型":
                imageList.add(R.mipmap.d2_type);
                break;
            case "D3户型":
                imageList.add(R.mipmap.d3_type);
                break;
            case "D6户型":
                imageList.add(R.mipmap.d6_type);
                break;

        }
    }

}
