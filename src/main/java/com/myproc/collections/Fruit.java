package com.myproc.collections;

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

    @Override
    public Apple clone() {
        return new Apple(this.size);
    }
}

class Orange extends Fruit {
    public Orange(int size) {
        super("Orange", size);
    }
}
