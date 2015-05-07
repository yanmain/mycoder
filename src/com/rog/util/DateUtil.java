package com.rog.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String format = "yyyy-MM-dd HH:mm:ss";
    public static String shortFormat = "yyyy-MM-dd";
    public static String hourFormat = "HH:mm";
    public static String miniFormat = "HH:mm:ss";
    private final static String dayNames[] = { "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday" };
    
    public static String getStrDate(Date date, String fmt) {
        SimpleDateFormat formatter = new SimpleDateFormat(fmt);
        String dateString = formatter.format(date);
        return dateString;
    }
    
    public static Date getDate(long date){
    	Date d = new Date(date);
    	return d;
    }
}
