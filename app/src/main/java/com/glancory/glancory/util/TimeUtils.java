package com.glancory.glancory.util;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by zhangqi on 19/2/8.
 */

public class TimeUtils {

    /**
     * 获取当前时间的小时情况（24时制）
     * @return
     */
    public static int getHour() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));

        int hour = 0;
        if (calendar.get(Calendar.AM_PM) == 0) {
            hour = calendar.get(Calendar.HOUR);
        } else {
            hour = calendar.get(Calendar.HOUR) + 12;
        }
        return hour;
    }
}
