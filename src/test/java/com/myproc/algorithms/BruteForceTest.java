package com.myproc.algorithms;

import com.myproc.util.TestDataUtil;
import org.junit.Assert;
import org.junit.Test;

public class BruteForceTest {
    @Test
    public void testSelectionSort() {
        int[] array = TestDataUtil.createRandomIntArray(100);
        BruteForce.selectionSort(array);
        for (int i = 0; i < array.length - 1; i++) {
            Assert.assertTrue(array[i] < array[i + 1]);
        }
    }

    @Test
    public void testBubbleSort() {
        int[] array = TestDataUtil.createRandomIntArray(100);
        BruteForce.bubbleSort(array);
        for (int i = 0; i < array.length - 1; i++) {
            Assert.assertTrue(array[i] < array[i + 1]);
        }
    }

    @Test
    public void testStringMatch1() {
        char[] strArray1 = "abcdefghijklnmaskdfjksldfj".toCharArray();
        char[] strArray2 = "ijklnma".toCharArray();
        int result = BruteForce.stringMatch(strArray1, strArray2);
        Assert.assertEquals(8, result);
    }

    @Test
    public void testStringMatch2() {
        char[] strArray1 = "abcdedfj".toCharArray();
        char[] strArray2 = "dfj".toCharArray();
        int result = BruteForce.stringMatch(strArray1, strArray2);
        Assert.assertEquals(5, result);
    }

    @Test
    public void testStringMatch3() {
        char[] strArray1 = "abcdedfj".toCharArray();
        char[] strArray2 = "abc".toCharArray();
        int result = BruteForce.stringMatch(strArray1, strArray2);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testStringMatch4() {
        char[] strArray1 = "ab".toCharArray();
        char[] strArray2 = "a".toCharArray();
        int result = BruteForce.stringMatch(strArray1, strArray2);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testStringMatch5() {
        char[] strArray1 = "ab".toCharArray();
        char[] strArray2 = "b".toCharArray();
        int result = BruteForce.stringMatch(strArray1, strArray2);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testStringMatch6() {
        int result = BruteForce.stringMatch(null, null);
        Assert.assertEquals(-1, result);
    }
}
