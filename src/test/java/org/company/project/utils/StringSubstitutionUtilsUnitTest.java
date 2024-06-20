package org.company.project.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StringSubstitutionUtilsUnitTest {

    private final static String SOURCE_STRING = "Test data pack";
    private final static String REPLACEMENT_STRING = "123";

    @Mock
    private Logger loggerMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void replaceSubarray_should_replace_subarray_by_replacement() {
        char[] source = SOURCE_STRING.toCharArray();
        char[] subarray = "a".toCharArray();
        char[] replacement = REPLACEMENT_STRING.toCharArray();

        char[] result = StringSubstitutionUtils.replaceSubarray(source, subarray, replacement);

        assertArrayEquals("Test d123t123 p123ck".toCharArray(), result);
    }

    @Test
    public void replaceSubarray_should_throw_illegal_argument_exception_when_source_null() {
        char[] subarray = "o".toCharArray();
        char[] replacement = REPLACEMENT_STRING.toCharArray();

        assertThrows(IllegalArgumentException.class, () -> StringSubstitutionUtils.replaceSubarray(null, subarray, replacement));
    }

    @Test
    public void replaceSubarray_should_throw_illegal_argument_exception_when_subarray_null() {
        char[] source = SOURCE_STRING.toCharArray();
        char[] replacement = REPLACEMENT_STRING.toCharArray();

        assertThrows(IllegalArgumentException.class, () -> StringSubstitutionUtils.replaceSubarray(source, null, replacement));
    }

    @Test
    public void replaceSubarray_should_throw_illegal_argument_exception_when_replacement_null() {
        char[] source = SOURCE_STRING.toCharArray();
        char[] subarray = "a".toCharArray();

        assertThrows(IllegalArgumentException.class, () -> StringSubstitutionUtils.replaceSubarray(source, subarray, null));
    }

    @Test
    public void replaceSubarray_should_return_the_source_when_subarray_empty() {
        char[] source = SOURCE_STRING.toCharArray();
        char[] subarray = new char[0];
        char[] replacement = REPLACEMENT_STRING.toCharArray();

        char[] result = StringSubstitutionUtils.replaceSubarray(source, subarray, replacement);

        assertArrayEquals(source, result);
    }

    @Test
    public void replaceSubarray_should_return_the_source_when_no_match() {
        char[] source = SOURCE_STRING.toCharArray();
        char[] subarray = "xyz".toCharArray();
        char[] replacement = REPLACEMENT_STRING.toCharArray();

        char[] result = StringSubstitutionUtils.replaceSubarray(source, subarray, replacement);

        assertArrayEquals(source, result);
    }
}
