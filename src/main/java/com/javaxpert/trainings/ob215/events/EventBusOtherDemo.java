package com.javaxpert.trainings.ob215.events;

import com.google.common.eventbus.EventBus;

public class EventBusOtherDemo {
    public static void main(String[] args) {
        EventBus bus = new EventBus();
        MultipleListener handler1 = new MultipleListener("h1");
        MultipleListener handler2 = new MultipleListener("h2");
        bus.register(handler1);
        bus.register(handler2);
        bus.post(1);
        bus.post(2);
        bus.post("update?");
        bus.unregister(handler1);
        bus.post(3);
    }
}
