package com.example.yubaby.util;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/13 11:42
 **/
public class JodaInstance {
    public static DateTime getJodaInstanceByJDK(Date date) {
        return new DateTime(date);
    }
}
