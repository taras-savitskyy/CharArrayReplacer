package org.company.project.utils;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@UtilityClass
public class StringSubstitutionUtils {

    private static final Logger logger = LoggerFactory.getLogger(StringSubstitutionUtils.class);

    public static char[] replaceSubarray(char[] source, char[] subarray, char[] replacement) {
        long wTime = System.nanoTime();

        String sourceString = new String(source);
        String subarrayString = new String(subarray);
        String replacementString = new String(replacement);

        char[] result = sourceString.replace(subarrayString, replacementString).toCharArray();
        logger.info("StringSubstitutionUtils replaceSubarray wTime={}", DateTimeUtils.wTime(wTime));

        return result;
    }
}
