package com.javaxpert.trainings.ob215.blotter;

import java.util.Objects;

/**
 * Pojo used to transport messages
 */
public class ReutersMessage {
    private String msg;
    private short priority;
    private long timeStamp;

    public ReutersMessage(String msg, short priority, long timeStamp) {
        this.msg = msg;
        this.priority = priority;
        this.timeStamp = timeStamp;
    }

    public String getMsg() {
        return msg;
    }

    public short getPriority() {
        return priority;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReutersMessage)) return false;
        ReutersMessage that = (ReutersMessage) o;
        return getTimeStamp() == that.getTimeStamp() &&
                getMsg().equals(that.getMsg());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMsg(), getTimeStamp());
    }
}
