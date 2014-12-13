package com.k.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utilities
{
    public final static SimpleDateFormat mysqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public static String calendarToString(Calendar cal)
    {
        if (cal == null)
            return "";
        else
            return mysqlDateFormat.format(cal);
    }
    
    public static Calendar stringToCalendar(String string)
    {
        if (string == null || string.length() == 0)
        {
            return null;
        }
        else
        {
            if (string.length() >= 10)
            {
                Integer year = Integer.parseInt(string.substring(0,4));
                Integer month = Integer.parseInt(string.substring(5,7));
                Integer day = Integer.parseInt(string.substring(8,10));
                
                Calendar cal = Calendar.getInstance();
                
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, (month - 1));
                cal.set(Calendar.DATE, day);
                
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                
                return cal;
            }
            else
                throw new IllegalArgumentException("Invalid string: " + string + " to convert to calendar");
        }
    }
}
