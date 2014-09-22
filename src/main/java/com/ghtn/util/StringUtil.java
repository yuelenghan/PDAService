package com.ghtn.util;

public class StringUtil {

    public static boolean isNullStr(String s) {
        if (s == null || s.trim().equals("") || s.trim().equals("null")) {
            return true;
        }
        return false;
    }

    public static String processNullStr(String s) {
        if (isNullStr(s)) {
            return "";
        }
        return s;
    }

/*
    public static void main(String[] args) {
        System.out.println(processDateStr("2014-02-01"));
    }
*/

    /**
     * 把2014-02-01转变为2014-2-1
     *
     * @param dateStr
     * @return
     */
    public static String processDateStr(String dateStr) {
        if (!isNullStr(dateStr)) {
            String[] ss = dateStr.split("-");
            int month = Integer.parseInt(ss[1]);
            int day = Integer.parseInt(ss[2]);
            return ss[0] + "-" + month + "-" + day;
        }

        return "";
    }
}
