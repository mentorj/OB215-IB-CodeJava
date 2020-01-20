package com.javaxpert.trainings.ob215.blotter;

import com.google.common.eventbus.Subscribe;

public class MessageHandler {

    @Subscribe
    public void receiveReutersmessage(ReutersMessage m){
        System.out.println("received new message " + m.getMsg());
    }
}
