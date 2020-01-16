package com.javaxpert.trainings.ob215.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Random;

public class CustomHandler implements InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invocation");
        return new Random().nextInt();
    }
}