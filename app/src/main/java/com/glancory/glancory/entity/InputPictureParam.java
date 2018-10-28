package com.glancory.glancory.entity;

import android.graphics.PointF;

/**
 * Created by zhangqi on 18/10/28.
 */

public class InputPictureParam {
    private int width;
    private int height;
    private PointF startPoint;
    private float blankWidth;
    private float blankHeight;
    private int bakgroundColor;

    public InputPictureParam() {

    }

    public InputPictureParam(int width,
                             int height,
                             PointF startPoint,
                             float blankWidth,
                             float blankHeight,
                             int bakgroundColor) {
        setBakgroundColor(bakgroundColor);
        setblankHeight(blankHeight);
        setblankWidth(blankWidth);
        setHeight(height);
        setWidth(width);
        setStartPoint(startPoint);
        
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setStartPoint(PointF startPoint) {
        this.startPoint = startPoint;
    }

    public void setblankWidth(float blankWidth) {
        this.blankWidth = blankWidth;
    }

    public void setblankHeight(float blankHeight) {
        this.blankHeight = blankHeight;
    }

    public void setBakgroundColor(int bakgroundColor) {
        this.bakgroundColor = bakgroundColor;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PointF getStartPoint() {
        return startPoint;
    }

    public float getblankWidth() {
        return blankWidth;
    }

    public float getblankHeight() {
        return blankHeight;
    }

    public int getBakgroundColor() {
        return bakgroundColor;
    }
}
