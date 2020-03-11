package com.windfallsheng.strategypatterncase.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lzsheng
 */
public class TimeUtils {

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStrDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
