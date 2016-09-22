package com.deepak.bridge;

/**
 * Created by panded4 on 9/7/2016.
 * Bridge design patterns
 * example: PrintWriter class, runtime polymorphism
 */

interface Switch{
    public void on();
    public void off();
}

class Fan implements Switch{
    @Override
    public void off() {
        System.out.println("Fan stop.");
    }

    @Override
    public void on() {
        System.out.println("Fan running...");
    }
}
class Bulb implements Switch{
    @Override
    public void on() {
        System.out.println("bulb On *");
    }

    @Override
    public void off() {
        System.out.println("bulb Off-");
    }
}
final class ElectronicComponent {
    public static Switch getComponent(String comp) {
        if (comp.equals("fan"))
            return new Fan();
        else if (comp.equals("bulb"))
            return new Bulb();
        return null;
    }
}
//main class
public class BridgeDemo {
    public static void main(String[] args) {
        Switch sw=ElectronicComponent.getComponent(args[0]);
        sw.on();
        sw.off();
    }
}
