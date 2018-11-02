package com.glancory.glancory.entity;

import android.graphics.Bitmap;
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

    private Bitmap bitmap;

    public InputPictureParam() {

    }

    public InputPictureParam(int width,
                             int height,
                             PointF startPoint,
                             float blankWidth,
                             float blankHeight,
                             int bakgroundColor) {
        setBakgroundColor(bakgroundColor);
        setBlankHeight(blankHeight);
        setBlankWidth(blankWidth);
        setHeight(height);
        setWidth(width);
        setStartPoint(startPoint);
        
    }

    public float getBlankWidth() {
        return blankWidth;
    }

    public void setBlankWidth(float blankWidth) {
        this.blankWidth = blankWidth;
    }

    public float getBlankHeight() {
        return blankHeight;
    }

    public void setBlankHeight(float blankHeight) {
        this.blankHeight = blankHeight;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
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

    public int getBakgroundColor() {
        return bakgroundColor;
    }
}
