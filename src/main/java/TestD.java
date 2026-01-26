package main.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestD {
    @Test
    public void testArr2HappyPath() {
        DD obj = new DD();
        List<Integer> expected = Arrays.asList(0, 2, 4, 6, 8, 10);
        assertEquals(expected, obj.arr2(5));
    }

    @Test
    public void testArr2EdgeCaseZero() {
        DD obj = new DD();
        List<Integer> expected = Collections.singletonList(0);
        assertEquals(expected, obj.arr2(0));
    }

    @Test
    public void testArr2EdgeCaseNegative() {
        DD obj = new DD();
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, obj.arr2(-5));
    }
}
