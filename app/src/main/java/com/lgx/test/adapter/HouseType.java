package com.lgx.test.adapter;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Harry on 2017/8/15.
 */

public class HouseType implements Parcelable{
    private String typeName;
    private String realArea;
    private String givenArea;

    protected HouseType(Parcel in) {
        typeName = in.readString();
        realArea = in.readString();
        givenArea = in.readString();
    }
    public HouseType(){

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(typeName);
        dest.writeString(realArea);
        dest.writeString(givenArea);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HouseType> CREATOR = new Creator<HouseType>() {
        @Override
        public HouseType createFromParcel(Parcel in) {
            return new HouseType(in);
        }

        @Override
        public HouseType[] newArray(int size) {
            return new HouseType[size];
        }
    };

    public String getTypeName() {
        return typeName;
    }

    public String getRealArea() {
        return realArea;
    }

    public String getGivenArea() {
        return givenArea;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setRealArea(String realArea) {
        this.realArea = realArea;
    }

    public void setGivenArea(String givenArea) {
        this.givenArea = givenArea;
    }
}
