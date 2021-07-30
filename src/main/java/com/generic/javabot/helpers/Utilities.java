package com.generic.javabot.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public
class Utilities {
    public
    static
    String currentDateTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String strDate = dateFormat.format(date);
        return strDate;
    }
}