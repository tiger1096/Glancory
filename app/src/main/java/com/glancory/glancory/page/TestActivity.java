package com.glancory.glancory.page;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.glancory.glancory.R;
import com.glancory.glancory.util.TimeUtils;

public class TestActivity extends AppCompatActivity {
    TextView mDayNightText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mDayNightText = findViewById(R.id.dayNightText);
        int hour = TimeUtils.getHour();
        if (hour >= 5 && hour <= 12) {
            mDayNightText.setText("MORNING");
        } else if (hour > 12 && hour <= 18) {
            mDayNightText.setText("AFTERNOON");
        } else {
            mDayNightText.setText("NIGHT");
        }
    }


}
