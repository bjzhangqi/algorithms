package com.myproc.basics;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.stream.Stream;

public class BasicsTest {
    @Test
    public void testStream() {
        Stream<String> ss = Stream.of("foo", "bar1");
        Assert.assertTrue(ss instanceof Stream);
        for (String s : ss.filter(s -> s.length() == 4).toArray(String[]::new)) {
            System.out.println(s);
        }
        for (Method m : ss.getClass().getMethods()) {
            System.out.println(m.toGenericString());
        }
    }
}
