package com.javaxpert.trainings.ob215.events;

import com.google.common.eventbus.EventBus;

public class EventBusDemo {
    public static void main(String[] args) {
        // create the bus
        EventBus bus = new EventBus();
        // register the events handler
        MultipleListener handler = new MultipleListener();
        bus.register(handler);
        // posts some events
        bus.post(2);
        bus.post(3);
        bus.post("counter changed");
        bus.unregister(handler);
        bus.post(4)
        ;
    }
}
