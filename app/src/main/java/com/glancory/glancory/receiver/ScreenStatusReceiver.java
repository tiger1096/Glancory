package com.glancory.glancory.receiver;

import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class ScreenStatusReceiver extends BroadcastReceiver {

    Context mContext;

    public ScreenStatusReceiver() {
        super();
    }

    public ScreenStatusReceiver(Context context) {
        mContext = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        System.out.println("ScreenStatusReceiver receive " + intent.getAction());

        Log.e("ScreenStatusReceiver", "ScreenStatusReceiver receive " + intent.getAction());

        if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            SetLockWallPaper();
        }

        //throw new UnsupportedOperationException("Not yet implemented");
    }

    private void SetLockWallPaper() {
        // TODO Auto-generated method stub
        try {
            WallpaperManager mWallManager = WallpaperManager.getInstance(mContext);
            mWallManager.setBitmap(getImageFromAssetsFile("bg1.jpg"), null, false, WallpaperManager.FLAG_LOCK);
        } catch (Exception e) {
            // TODO Auto-generated catch block e.printStackTrace();

            Log.e("ScreenStatusReceiver", "ScreenStatusReceiver receive fail " + e.getMessage() + ", and name = " + e.getClass().getName());

        }
    }

    private Bitmap getImageFromAssetsFile(String fileName)
    {
        Bitmap image = null;
        AssetManager am = mContext.getResources().getAssets();
        try
        {
            InputStream is = am.open(fileName);
            image = BitmapFactory.decodeStream(is);
            is.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;

    }
}
