package com.glancory.glancory.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.glancory.glancory.receiver.ScreenStatusReceiver;

public class ScreenMonitorService extends Service {
    private ScreenStatusReceiver mScreenStatusReceiver;

    public ScreenMonitorService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("ScreenMonitorService","ScreenMonitorService start");
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
