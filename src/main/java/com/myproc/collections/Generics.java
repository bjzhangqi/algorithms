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

abstract class Fruit implements Comparable<Fruit> {
    protected String name;
    protected int size;

    protected Fruit(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Fruit) {
            Fruit that = (Fruit) o;
            return this.name.equals(that.name) && this.size == that.size;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Fruit that) {
        return this.size < that.size ? -1 :
                this.size == that.size ? 0 : 1;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 29 + size;
    }
}

class Apple extends Fruit {
    public Apple(int size) {
        super("Apple", size);
    }
}

class Orange extends Fruit {
    public Orange(int size) {
        super("Orange", size);
    }
}
