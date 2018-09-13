package com.glancory.glancory.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ScreenMonitorService extends Service {
    public ScreenMonitorService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
