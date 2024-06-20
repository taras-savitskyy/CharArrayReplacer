package org.company.project.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CharArraySubstitutionUtilsUnitTest {

    @Mock
    private Logger loggerMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void replaceSubarray_should_replace_subarray_by_replacement() {
        char[] source = "Test data pack".toCharArray();
        char[] subarray = "a".toCharArray();
        char[] replacement = "123".toCharArray();

        char[] result = CharArraySubstitutionUtils.replaceSubarray(source, subarray, replacement);

        assertArrayEquals("Test d123t123 p123ck".toCharArray(), result);

        verify(loggerMock, times(1)).info(anyString());
    }

    @Test
    public void replaceSubarray_should_throw_illegal_argument_exception_when_source_null() {
        char[] subarray = "o".toCharArray();
        char[] replacement = "123".toCharArray();

        assertThrows(IllegalArgumentException.class, () -> CharArraySubstitutionUtils.replaceSubarray(null, subarray, replacement));
    }

    @Test
    public void replaceSubarray_should_throw_illegal_argument_exception_when_subarray_null() {
        char[] source = "Test data pack".toCharArray();
        char[] replacement = "123".toCharArray();

        assertThrows(IllegalArgumentException.class, () -> CharArraySubstitutionUtils.replaceSubarray(source, null, replacement));
    }

    @Test
    public void replaceSubarray_should_throw_illegal_argument_exception_when_replacement_null() {
        char[] source = "Test data pack".toCharArray();
        char[] subarray = "a".toCharArray();

        assertThrows(IllegalArgumentException.class, () -> CharArraySubstitutionUtils.replaceSubarray(source, subarray, null));
    }

    @Test
    public void replaceSubarray_should_return_the_source_when_subarray_empty() {
        char[] source = "Test data pack".toCharArray();
        char[] subarray = new char[0];
        char[] replacement = "123".toCharArray();

        char[] result = CharArraySubstitutionUtils.replaceSubarray(source, subarray, replacement);

        assertArrayEquals(source, result);
    }

    @Test
    public void replaceSubarray_should_return_the_source_when_no_match() {
        char[] source = "Test data pack".toCharArray();
        char[] subarray = "xyz".toCharArray();
        char[] replacement = "123".toCharArray();

        char[] result = CharArraySubstitutionUtils.replaceSubarray(source, subarray, replacement);

        assertArrayEquals(source, result);
    }
}
