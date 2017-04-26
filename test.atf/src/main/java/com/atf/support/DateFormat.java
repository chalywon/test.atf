package com.atf.support;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    private static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static String format(Date date) {
        return DEFAULT_DATE_FORMAT.format(date);
    }
    
    public static int Date2TimeStamp(String dateStr, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return (int) (sdf.parse(dateStr).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
