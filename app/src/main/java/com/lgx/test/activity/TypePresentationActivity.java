package com.lgx.test.activity;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lgx.test.R;
import com.lgx.test.adapter.HouseType;
import com.lgx.test.adapter.RecyclerViewAdapter;
import com.lgx.test.base.BaseActivity;
import com.lgx.test.common.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harry on 2017/8/15.
 */

public class TypePresentationActivity extends BaseActivity {
    private List<HouseType> houseTypeList;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_presentation;
    }

    @Override
    protected void initView() {

        initData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(houseTypeList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClick(new RecyclerViewAdapter.OnItemViewClick() {
            @Override
            public void onClick(int position, View view) {
                ActivityOptionsCompat optionsCompatCompany = ActivityOptionsCompat.makeSceneTransitionAnimation(TypePresentationActivity.this,
                        view, Constants.DESCRIPTION_IMAGE);
                Intent intent=new Intent(TypePresentationActivity.this,
                        RealHouseTypeActivity.class);
                intent.putExtra(Constants.HOUSE_TYPE,houseTypeList.get(position));
                ActivityCompat.startActivity(TypePresentationActivity.this,intent , optionsCompatCompany.toBundle());
            }
        });
    }

    private void initData() {
        houseTypeList = new ArrayList<>();
        String[] typeStrings = getResources().getStringArray(R.array.type);

        HouseType type1 = new HouseType();
        type1.setTypeName(typeStrings[0]);
        type1.setRealArea("294");
        type1.setGivenArea("100");
        houseTypeList.add(type1);

        HouseType type2 = new HouseType();
        type2.setTypeName(typeStrings[1]);
        type2.setRealArea("263");
        type2.setGivenArea("116");
        houseTypeList.add(type2);

        HouseType type3 = new HouseType();
        type3.setTypeName(typeStrings[2]);
        type3.setRealArea("268");
        type3.setGivenArea("117");
        houseTypeList.add(type3);

        HouseType type4 = new HouseType();
        type4.setTypeName(typeStrings[3]);
        type4.setRealArea("275");
        type4.setGivenArea("93");
        houseTypeList.add(type4);

        HouseType type5 = new HouseType();
        type5.setTypeName(typeStrings[4]);
        type5.setRealArea("247");
        type5.setGivenArea("77");
        houseTypeList.add(type5);

        HouseType type6 = new HouseType();
        type6.setTypeName(typeStrings[5]);
        type6.setRealArea("244");
        type6.setGivenArea("76");
        houseTypeList.add(type6);

        HouseType type7 = new HouseType();
        type7.setTypeName(typeStrings[6]);
        type7.setRealArea("406");
        type7.setGivenArea("179");
        houseTypeList.add(type7);


        HouseType type8 = new HouseType();
        type8.setTypeName(typeStrings[7]);
        type8.setRealArea("136");
        type8.setGivenArea("13");
        houseTypeList.add(type8);

        HouseType type9 = new HouseType();
        type9.setTypeName(typeStrings[8]);
        type9.setRealArea("135");
        type9.setGivenArea("24");
        houseTypeList.add(type9);

        HouseType type10 = new HouseType();
        type10.setTypeName(typeStrings[9]);
        type10.setRealArea("135");
        type10.setGivenArea("18");
        houseTypeList.add(type10);

        HouseType type11 = new HouseType();
        type11.setTypeName(typeStrings[10]);
        type11.setRealArea("161");
        type11.setGivenArea("101");
        houseTypeList.add(type11);
    }
}
