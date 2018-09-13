package com.glancory.glancory;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.glancory.glancory.receiver.ScreenStatusReceiver;

public class MainActivity extends AppCompatActivity {

    private ScreenStatusReceiver mScreenStatusReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScreenStatusReceiver = new ScreenStatusReceiver(this);
        IntentFilter mIntentFilter = new IntentFilter();

        mIntentFilter.addAction(Intent.ACTION_SCREEN_ON);
        mIntentFilter.addAction(Intent.ACTION_SCREEN_OFF);
//        mIntentFilter.addAction(Intent.ACTION_BATTERY_LOW);
//        mIntentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

        Intent i = registerReceiver(mScreenStatusReceiver, mIntentFilter);
        Log.e("ha","Intent.ACTION_SCREEN_ON");
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

        unregisterReceiver(mScreenStatusReceiver);
        Log.e("ha","unIntent.ACTION_SCREEN_ON");

    }
}
