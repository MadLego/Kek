package com.epam.parser;

import java.sql.Timestamp;

public class DateTimeParser {
    public static String fromTimestamp(String s){
        return s.replace(" ","T").substring(0,s.indexOf("."));
    }
    public static Timestamp toTimestamp(String s){
        return Timestamp.valueOf(s.replace("T"," ").concat(".0"));
    }
    public static Timestamp toTimestampAlter(String s){
        return Timestamp.valueOf(s.replace("T"," ").concat(":00.0"));
    }
    public static String troubleWithChange(String time){
        int point = time.indexOf("T");
        if (time.substring(point).length()==6){
            time+=":00";
        }
        return time;
    }
}
