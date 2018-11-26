package com.myproc.util;

import java.security.SecureRandom;

public class TestDataUtil {
    public static int[] createRandomIntArray(int length) {
        int[] array =  new int[length];
        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < length; i++) {
            array[i] = secureRandom.nextInt();
        }
        return array;
    }

    public static <T> void swap(T[] a, int i, int j) {
        if (a != null) {
            T t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
}
