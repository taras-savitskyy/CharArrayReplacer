package org.company.project.utils;

import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@UtilityClass
public class CharArraySubstitutionUtils {

    private static final Logger logger = LoggerFactory.getLogger(StringSubstitutionUtils.class);

    public static char[] replaceSubarray(char[] source, char[] subarray, char[] replacement) {
        long wTime = System.currentTimeMillis();

        if (source == null || subarray == null || replacement == null) {
            throw new IllegalArgumentException("Input arrays cannot be null");
        }

        if (subarray.length == 0) {
            return source;
        }

        List<Character> resultList = new ArrayList<>();
        int subarrayLength = subarray.length;
        int i = 0;

        while (i < source.length) {
            if (isSubarrayMatch(source, subarray, i)) {
                for (char c : replacement) {
                    resultList.add(c);
                }
                i += subarrayLength;
            } else {
                resultList.add(source[i]);
                i++;
            }
        }

        char[] result = listToCharArray(resultList);
        logger.info("CharArraySubstitutionUtils replaceSubarray wTime={}", DateTimeUtils.wTime(wTime));

        return result;
    }

    private static char[] listToCharArray(List<Character> resultList) {
        int size = resultList.size();
        char[] result = new char[size];
        for (int i = 0; i < size; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    private static boolean isSubarrayMatch(char[] source, char[] subarray, int index) {
        for (int i = 0; i < subarray.length; i++) {
            if (source[index + i] != subarray[i]) {
                return false;
            }
        }

        return true;
    }
}
