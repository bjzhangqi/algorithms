package com.myproc.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Generics {
    public static <T> void copy(List<? super T> dst, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            dst.set(i, src.get(i));
//            dst.add(i, src.get(i));
        }
    }

    public static void count(Collection<? super Integer> ints, int n) {
        for (int i = 0; i < n; i++) {
            ints.add(i);
        }
    }

    public static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for (Number num : nums) s += num.doubleValue();
        return s;
    }

    public static <T> List<T> factory() {
        return new ArrayList<T>();
    }
}




