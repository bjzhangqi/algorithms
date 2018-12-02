package com.myproc.algorithms;

import java.security.InvalidParameterException;

public class DecreaseAndConquer {
    public static void insertionSort(int[] array) {
        if (array != null) {
            for (int i = 1; i < array.length; i++) {
                int v = array[i];
                int j = i - 1;
                while (j >= 0 && array[j] > v) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                array[j + 1] = v;
            }
        } else {
            throw new InvalidParameterException("InsertionSort parameter is not nullable!");
        }
    }
}