package com.glancory.glancory.PictureTextUtil;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;

import com.glancory.glancory.entity.InputPictureParam;
import com.glancory.glancory.entity.InputTextParam;
import com.glancory.glancory.entity.OutputPictureParam;

/**
 * Created by zhangqi on 18/10/28.
 */

public class TextUtil {
    public static Bitmap generateMeaningfulPicture(OutputPictureParam outputPictureParam,
                                                   InputPictureParam inputPictureParam,
                                                   InputTextParam inputTextParam) {
        Bitmap tarBitmap = inputPictureParam.getBitmap().copy(Bitmap.Config.ARGB_8888, true);
//        Bitmap tarbitmap = Bitmap.createBitmap(outoutPictureParam.getWidth(), outoutPictureParam.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(tarBitmap);

        TextPaint paint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        paint.setTypeface(Typeface.DEFAULT);
        paint.setTextSize(inputTextParam.getFontSize());
        paint.setColor(Color.BLACK);

        int w = tarBitmap.getWidth();
        int h = tarBitmap.getHeight();
        Log.e("TextUtil","inputTextParam.getTexts()[0] = " + inputTextParam.getTexts()[0]);
        canvas.drawText(inputTextParam.getTexts()[0], (float)w * inputPictureParam.getStartPoint().x, (float)h * inputPictureParam.getStartPoint().y, paint);

        canvas.save();
        canvas.restore();

        return tarBitmap;
    }
}
