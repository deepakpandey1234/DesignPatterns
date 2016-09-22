package com.deepak.behavioural.momento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panded4 on 9/8/2016.
 */
class Memento {
    String name;

    public Memento(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Originator {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Memento saveStateToMemento() {
        return new Memento(name);
    }

    public void getStateFromMemento(Memento memento) {
        name = memento.getName();
    }
}

class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}

public class MementoDemo {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();

        Originator originator = new Originator();
        originator.setName("Deepak");
        originator.setName("Hello");

        careTaker.add(originator.saveStateToMemento());

        originator.setName("Hi");
        careTaker.add(originator.saveStateToMemento());

        originator.setName("waka");
        originator.setName("jai");

        careTaker.add(originator.saveStateToMemento());

        originator.getStateFromMemento(careTaker.get(2));
        System.out.println(originator.getName());
    }
}

