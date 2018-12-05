package com.myproc.collections;

import java.util.ArrayList;
import java.util.List;

public class Cell<T> {
    private final int id;
    private final T value;
    private static int count = 0;
    private static List<Object> values = new ArrayList<>();

    private static synchronized int nextId() {
        return count++;
    }

    public Cell(T value) {
        this.value = value;
        this.id = nextId();
        values.add(value);
    }

    public T getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public static synchronized int getCount() {
        return count;
    }

    public static List<Object> getValues() {
        return values;
    }
}
