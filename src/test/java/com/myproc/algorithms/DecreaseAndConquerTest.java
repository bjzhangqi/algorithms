package com.myproc.algorithms;

import com.myproc.util.TestDataUtil;
import org.junit.Assert;
import org.junit.Test;

public class DecreaseAndConquerTest {

    @Test
    public void testInsertionSort() {
        int[] array = TestDataUtil.createRandomIntArray(100);
        DecreaseAndConquer.insertionSort(array);
        for (int i = 0; i < array.length - 1; i++) {
            Assert.assertTrue(array[i + 1] - array[i] > 0);
        }
    }
}
