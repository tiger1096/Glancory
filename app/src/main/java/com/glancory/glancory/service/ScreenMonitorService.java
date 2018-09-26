package com.glancory.glancory.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.glancory.glancory.receiver.ScreenStatusReceiver;

public class ScreenMonitorService extends Service {
    private ScreenStatusReceiver mScreenStatusReceiver;
    private ThreadGroup myThreads = new ThreadGroup("ServiceWorker");

    //private MediaSession mMediaSession;

    public ScreenMonitorService() {
        super();
        Log.e("ScreenMonitorService","ScreenMonitorService construct = " + (mScreenStatusReceiver == null) );
        //startScreenStatusReceiver();

        new Thread(myThreads, new StartMonitor(), "background").start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("ScreenMonitorService","ScreenMonitorService start");
        startScreenStatusReceiver();

        return Service.START_STICKY;
    }

    private void startScreenStatusReceiver() {
        if (mScreenStatusReceiver != null) {
            return ;
        }

        mScreenStatusReceiver = new ScreenStatusReceiver(this);
        IntentFilter mIntentFilter = new IntentFilter();

        mIntentFilter.addAction(Intent.ACTION_SCREEN_ON);
        mIntentFilter.addAction(Intent.ACTION_SCREEN_OFF);

        Intent i = registerReceiver(mScreenStatusReceiver, mIntentFilter);

        //TODO Xiaomi Phone use specail way to change lock picture
//        mMediaSession = new MediaSession(this, "ScreenInteract");
//        mMediaSession.setCallback(new MediaSession.Callback() {
//            @Override
//            public void onCommand(@NonNull String command, @Nullable Bundle args, @Nullable ResultReceiver cb) {
//                super.onCommand(command, args, cb);
//            }
//        });
//        mMediaSession.setActive(true);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        Log.e("ScreenMonitorService","ScreenMonitorService destroy");
        super.onDestroy();

        unregisterReceiver(mScreenStatusReceiver);
    }

    class StartMonitor implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Log.e("StartMonitor","StartMonitor sendBroadcast");
            sendBroadcast(new Intent("RestartSerivcesForSystemEventReceiver"));
        }
    }
}
