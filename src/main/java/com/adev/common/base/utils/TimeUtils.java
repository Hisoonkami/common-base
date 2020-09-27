package com.adev.common.base.utils;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class TimeUtils {

    public static String getGMTFormat(String format,Long timestamp) {
        if(null==timestamp){
            timestamp=System.currentTimeMillis();
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (sdf.getTimeZone().getID() != TimeZone.getTimeZone("GMT").getID()) {
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        }
        return sdf.format(timestamp);
    }
}
