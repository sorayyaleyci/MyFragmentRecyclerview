package com.sorayya.myfragmentrecyclerview;

import android.graphics.drawable.Drawable;

public class DataModel {
    private String title;
    private Drawable drawable;
    private String phoneNumber;
    private Integer drawableID;

    public DataModel(String title, Drawable drawable, String phoneNumber, Integer drawableID) {
        this.title = title;
        this.drawable = drawable;
        this.phoneNumber = phoneNumber;
        this.drawableID=drawableID;
    }

    public Integer getDrawableID() {
        return drawableID;
    }

    public void setDrawableID(Integer drawableID) {
        this.drawableID = drawableID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
