package org.study.demo.type;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhiboliu2 on 2017/9/19.
 */
public class TypeUtil {
    private static String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static String DATE_PATTERN = "yyyy-MM-dd";

    public static String getValue(Object val) {
        String result = "";
        if (val == null) {
            return result;
        }
        if (val instanceof Date) {
            SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTERN);
            result = sdf.format((Date) val);
        } else {
            result = String.valueOf(val);
        }
        return result;
    }
}
