package com.deepak.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panded4 on 9/8/2016.
 * Example: java.util.Observer/java.util.Observable (rarely used in real world though)
 All implementations of java.util.EventListener (practically all over Swing thus)
 javax.servlet.http.HttpSessionBindingListener
 */
class Subject{
    List<Observer> observers=new ArrayList<>();
    int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
    public void attach(Observer observer){
        observers.add(observer);
    }
    public void notifyAllObservers(){
        for(Observer obs:observers){
            obs.update();
        }
    }
}

abstract  class Observer{
    protected Subject subject;
    abstract void update();
}

class BinaryObserver extends Observer{
    public BinaryObserver(Subject subject) {
        this.subject=subject;
    }

    @Override
    void update() {
        System.out.println("BinaryObserver.update:  "+Integer.toBinaryString(subject.getState()));
    }
}
class OctalObserver extends Observer{
    public OctalObserver(Subject subject) {
        this.subject=subject;
    }

    @Override
    void update() {
        System.out.println("BinaryObserver.update:  "+Integer.toOctalString(subject.getState()));
    }
}
public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject=new Subject();
        subject.setState(10);
        System.out.println("::::::::::::::::::::::::::::::::::");
        subject.attach(new BinaryObserver(subject));
        subject.setState(20);
    }

}
