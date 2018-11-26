package com.myproc.algorithms;

public class BruteForce {
    public static void selectionSort(int[] array) {
        if (array != null) {
            if (array.length > 1) {
                for (int i = 0; i < array.length - 1; i++) {
                    int min = i;
                    for (int j = i + 1; j < array.length; j++) {
                        if (array[j] < array[min]) {
                            min = j;
                        }
                    }
                    int tmp = array[i];
                    array[i] = array[min];
                    array[min] = tmp;
                }
            }
        }
    }

    public static void bubbleSort(int[] array) {
        if (array != null) {
            if (array.length > 1) {
                for (int i = 0; i < array.length - 1; i++) {
                    for (int j = 0; j < array.length - 1 - i; j++) {
                        if (array[j] > array[j + 1]) {
                            int tmp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = tmp;
                        }
                    }
                }
            }
        }
    }

    public static int stringMatch(char[] strArray1, char[] strArray2) {
        if (strArray1 != null && strArray2 != null) {
            if (strArray1.length > strArray2.length && strArray1.length > 1) {
                for (int i = 0; i <= strArray1.length - strArray2.length; i++) {
                    int j = 0;
                    while (j < strArray2.length && strArray1[i + j] == strArray2[j]) {
                        j = j + 1;
                    }
                    if (j == strArray2.length) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

}