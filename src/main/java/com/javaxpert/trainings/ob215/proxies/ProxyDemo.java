package com.javaxpert.trainings.ob215.proxies;

import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        Customer instance = (Customer) Proxy.newProxyInstance(
                Customer.class.getClassLoader(),
                new Class[] {Customer.class},
                new CustomHandler()
        );
        System.out.println(instance.getRand());
        System.out.println(instance.getRand());
    }

}
