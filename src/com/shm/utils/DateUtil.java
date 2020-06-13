package com.shm.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	 
    public static java.sql.Date d2t(java.util.Date d) {
        if (null == d)
            return null;
        return new java.sql.Date(d.getTime());
    }
 
    public static java.util.Date t2d(java.sql.Date t) {
        if (null == t)
            return null;
        return new java.util.Date(t.getTime());
    }
    
    public static Timestamp u2s(java.util.Date u) {
        if (null == u)
            return null;
        return new Timestamp(u.getTime());
    }
 
    public static java.util.Date s2u(Timestamp s) {
        if (null == s)
            return null;
        return new java.util.Date(s.getTime());
    }
    
    public static String u2str(java.util.Date u) {
    	
    	if (null == u)
            return null;
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(u);
    }
    
    public static java.util.Date str2u(String str) {
    	
    	if (null == str)
            return null;
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	
    	java.util.Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return date;
    }
 
    
}