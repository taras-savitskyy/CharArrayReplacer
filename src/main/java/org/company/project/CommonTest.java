package org.company.project;

import org.company.project.utils.CharArraySubstitutionUtils;
import org.company.project.utils.StringSubstitutionUtils;

public class CommonTest {

    public static void main(String[] args) {
        char[] array1 = {'A', 'B', 'D', 'E', 'B', 'D'};
        char[] array2 = {'B', 'D'};
        char[] array3 = {'0', '1', '2'};

        char[] result1 = CharArraySubstitutionUtils.replaceSubarray(array1, array2, array3);
        System.out.println(result1);

        char[] resul2 = StringSubstitutionUtils.replaceSubarray(array1, array2, array3);
        System.out.println(resul2);
    }
}