package com.myproc.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenericsTest {

    @Test
    public void testCopy() {
        List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
        List<Integer> ints = Arrays.asList(5, 6);
        Collections.copy(objs, ints);
        Assert.assertEquals("[5, 6, four]", objs.toString());
    }

    @Test
    public void testSum() {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        Assert.assertTrue(6.0 == Generics.sum(ints));
        List<Double> doubles = Arrays.asList(2.78, 3.14);
        Assert.assertTrue(5.92 == Generics.sum(doubles));
        List<Number> nums = Arrays.<Number>asList(1, 2, 2.78, 3.14);
        Assert.assertTrue(8.92 ==  Generics.sum(nums));
    }
}
