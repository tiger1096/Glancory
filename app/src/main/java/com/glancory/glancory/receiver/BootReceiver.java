package com.glancory.glancory.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.glancory.glancory.service.ScreenMonitorService;

public class BootReceiver extends BroadcastReceiver {
    private static boolean isBoot = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(isBoot) {
            return ;
        }

        for (int i = 0; i < 3; i ++) {
            Log.e("BootReceiver", "BootReceiver receive msg");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        context.startService(new Intent(context, ScreenMonitorService.class));

        isBoot = true;
    }
}
