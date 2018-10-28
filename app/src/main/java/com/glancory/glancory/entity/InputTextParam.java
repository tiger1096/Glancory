package com.glancory.glancory.entity;

/**
 * Created by zhangqi on 18/10/28.
 */

public class InputTextParam {
    private String [] texts;
    private int fontType;
    private float fontSize;
    private int shadowType;
    private int category;

    public InputTextParam() {

    }

    public InputTextParam(String[] texts, int fontType, float fontSize, int shadowType, int category) {
        this.texts = texts;
        this.fontType = fontType;
        this.fontSize = fontSize;
        this.shadowType = shadowType;
        this.category = category;
    }

    public void setTexts(String[] texts) {
        this.texts = texts;
    }

    public void setFontType(int fontType) {
        this.fontType = fontType;
    }

    public void setFontSize(float fontSize) {
        this.fontSize = fontSize;
    }

    public void setShadowType(int shadowType) {
        this.shadowType = shadowType;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String[] getTexts() {
        return texts;
    }

    public int getFontType() {
        return fontType;
    }

    public float getFontSize() {
        return fontSize;
    }

    public int getShadowType() {
        return shadowType;
    }

    public int getCategory() {
        return category;
    }
}
