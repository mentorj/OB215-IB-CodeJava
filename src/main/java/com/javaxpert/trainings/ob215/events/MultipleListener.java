package com.javaxpert.trainings.ob215.events;

import com.google.common.eventbus.Subscribe;

public class MultipleListener {
    private String name="default";
    public MultipleListener() {
    }

    public MultipleListener(String name) {
        this.name = name;
    }

    @Subscribe
    public void doSomething(String msg){
        System.out.println("handler : " + name + " received a new String event :" + msg);
    }

    @Subscribe
    // beware use Object wrappers and not primitive types here
    public void doOther(Integer counter){
        System.out.println("Counter changed :" + counter + " says handler :" + name);
    }
}
