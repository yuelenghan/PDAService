package com.ghtn.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * User: Administrator
 * Date: 2014/4/1
 * Time: 9:52
 */
public class KeyUtil {

    public static String encryptByMD5(String s) {
        return DigestUtils.md5Hex(s).toUpperCase();
    }

/*    public static void main(String[] args) {
        System.out.println(encryptByMD5("123456"));
    }*/

}
