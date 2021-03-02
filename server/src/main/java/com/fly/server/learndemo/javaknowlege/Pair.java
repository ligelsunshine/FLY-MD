package com.fly.server.learndemo.javaknowlege;

/**
 * description: Pair
 * date: 2021/3/1 22:59
 * version: 1.0
 *
 * @author: LIGEL
 */
public class Pair<T> {
    private T first;
    private T second;
    public Pair(){
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
