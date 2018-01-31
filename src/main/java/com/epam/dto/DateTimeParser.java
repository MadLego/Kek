package com.epam.dto;

import java.sql.Timestamp;
import java.util.Arrays;

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
    public static String[] fromTimestampToString(Timestamp[] timestamps){
        String [] arr = new String[2];
        int index =timestamps[0].toString().indexOf('.');
        arr[0]=timestamps[0].toString().substring(0,index);
        arr[1]=timestamps[1].toString().substring(0,index);
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
