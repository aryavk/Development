package com.k.customEditorTypes;

import java.beans.PropertyEditorSupport;
import java.util.Calendar;

import com.k.common.Utilities;

public class CalendarEditor extends PropertyEditorSupport
{
    @Override
    public String getAsText()
    {
        Calendar value = (Calendar) getValue();
        
        String text = Utilities.calendarToString(value);
        
        if (text != null)
            return text;
        else
            return "";
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        if (text != null && !text.equals("0"))
        {
            Calendar cal = Utilities.stringToCalendar(text);
            setValue(cal);
        }
        else
            setValue(null);
    }
}
