package com.glancory.glancory;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.glancory.glancory.receiver.BootReceiver;

public class MainActivity extends AppCompatActivity {
    private BootReceiver mBootReveiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBootReveiver = new BootReceiver();
        IntentFilter intent = new IntentFilter();
        intent.addAction("RestartSerivcesForSystemEventReceiver");
        registerReceiver(mBootReveiver, intent);

        sendBroadcast(new Intent("RestartSerivcesForSystemEventReceiver"));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
