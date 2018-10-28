package com.glancory.glancory.entity;

/**
 * Created by zhangqi on 18/10/28.
 */

public class OutoutPictureParam {
    private int width;
    private int height;

    public OutoutPictureParam() {

    }

    public OutoutPictureParam(int width, int height) {
        setHeight(height);
        setWidth(width);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
