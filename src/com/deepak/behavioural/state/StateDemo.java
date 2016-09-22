package com.deepak.behavioural.state;

/**
 * Created by panded4 on 9/8/2016.
 */

abstract class Greeting {
    protected int time;

    static Greeting getObject() {
        return new GreetingImpl();
    }

    public abstract void greet();

    public void setTime(int time) {
        this.time = time;
    }
}

class GreetingImpl extends Greeting {
    @Override
    public void greet() {
        Greeting greeting = new Morning();
        if (time > 5 && time < 12)
            greeting = new Morning();
        else
            greeting = new AfterNoon();

        greeting.greet();
    }
}

class Morning extends Greeting {
    @Override
    public void greet() {
        System.out.println("Good morning...");
    }
}

class AfterNoon extends Greeting {
    @Override
    public void greet() {
        System.out.println("Good noon...");
    }
}

public class StateDemo {
    public static void main(String[] args) {
        Greeting greeting = Greeting.getObject();
        greeting.greet();

        greeting.setTime(8);
        greeting.greet();
    }
}
