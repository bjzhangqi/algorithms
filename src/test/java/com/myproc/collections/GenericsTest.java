package com.myproc.collections;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;

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
        Assert.assertTrue(8.92 == Generics.sum(nums));
    }

    @Test
    public void testInstanceCreation() {
        List<Number> nums = new ArrayList<Number>();
        List<? super Number> sink = nums;
        List<? extends Number> source = nums;
        for (int i = 0; i < 10; i++) sink.add(i);
        double sum = 0;
        for (Number num : source) sum += num.doubleValue();
        Assert.assertTrue(45.0 == sum);
        List<Object> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 2, 3));
    }

    @Test
    public void testNestedWildCards() {
        List<List<?>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 2, 3));
        lists.add(Arrays.asList("four", "five"));
        Assert.assertEquals("[[1, 2, 3], [four, five]]", lists.toString());
    }

    @Test
    public void testGenericMethodCall() {
        List<?> list = Generics.factory();
        List<?> list2 = Generics.<Object>factory();
        List<List<?>> list3 = Generics.<List<?>>factory();
    }

    @Test
    public void testMaxFruit() {
        Apple a1 = new Apple(1);
        Apple a2 = new Apple(2);
        Orange o3 = new Orange(3);
        Orange o4 = new Orange(4);
        List<Apple> apples = Arrays.asList(a1, a2);
        Assert.assertEquals(a2, Collections.max(apples));
        List<Orange> oranges = Arrays.asList(o3, o4);
        Assert.assertEquals(o4, Collections.max(oranges));
        List<Fruit> mixed = Arrays.<Fruit>asList(a1, o3);
        Assert.assertEquals(o3, Collections.max(mixed));
    }

    @Test
    public void testComparator() {
        Comparator<String> orderSize =
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return
                                o1.length() < o2.length() ? -1 :
                                        o1.length() > o2.length() ? 1 :
                                                o1.compareTo(o2);
                    }
                };
        Assert.assertTrue("two".compareTo("three") > 0);
        Assert.assertTrue(orderSize.compare("two", "three") < 0);
    }

    @Test
    public void testBridge() {
        for (Method m : Integer.class.getMethods()
        ) {
            if (m.getName().equals("compareTo")) {
                System.out.println(m.toGenericString());
            }
        }

        for (Method m : Apple.class.getMethods()) {
            if (m.getName().equals("clone")) {
                System.out.println(m.toGenericString());
            }
        }
    }

    @Test
    public void testCell() {
        Cell<String> a = new Cell<>("one");
        Cell<Integer> b = new Cell<>(2);
        Assert.assertTrue(a.getId() == 0 && b.getId() == 1 && Cell.getCount() == 2);
        Assert.assertEquals("[one, 2]", Cell.getValues().toString());
    }

}
