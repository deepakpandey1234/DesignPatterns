package com.deepak.behavioural.template;

/**
 * Created by panded4 on 9/8/2016.
 * Example: JDBC, HTTPServlet internally uses
 */
abstract class Game{
    abstract void start();
    abstract void interval();
    abstract void result();
    public final void play(){
        start();
        interval();
        result();
    }
}
class Cricket extends Game{
    @Override
    void start() {
        System.out.println("Cricket.play");
    }

    @Override
    void interval() {
        System.out.println("Cricket.interval");
    }

    @Override
    void result() {
        System.out.println("Cricket.result");
    }
}

class Football extends Game{
    @Override
    void start() {
        System.out.println("Football.play");
    }

    @Override
    void interval() {
        System.out.println("football.interval");
    }

    @Override
    void result() {
        System.out.println("football.result");
    }
}
public class TemplateDemo {
    public static void main(String[] args) {
        Game game=new Cricket();
        game.play();
        System.out.println("::::::::::::::::::::");
        game=new Football();
        game.play();
    }
}
