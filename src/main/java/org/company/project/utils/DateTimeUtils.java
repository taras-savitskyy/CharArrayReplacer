package org.company.project.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DateTimeUtils {

    public static long wTime(long time) {
        return System.currentTimeMillis() - time;
    }

}
