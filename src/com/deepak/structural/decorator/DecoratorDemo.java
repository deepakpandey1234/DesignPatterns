package com.deepak.decorator;

/**
 * Created by panded4 on 9/7/2016.
 * Example : Java IO
 */
interface Car {
    public void assemble();
}
class BasicCar implements Car{
    @Override
    public void assemble() {
        System.out.println("BasicCar.assemble");
    }
}

class CarDecorator implements Car{
    public Car car;
    public CarDecorator(Car c){
        car=c;
    }

    @Override
    public void assemble() {
        car.assemble();
    }
}

class SportsCar extends CarDecorator{
    public SportsCar(Car c){
        super(c);
    }

    @Override
    public void assemble() {
        car.assemble();
        System.out.println("SportsCar.assemble"+" Adding sports car features");
    }
}

class LuxuryCar extends CarDecorator{
    public LuxuryCar(Car c){
        super(c);
    }

    @Override
    public void assemble() {
        car.assemble();
        System.out.println("LuxuryCar.assemble"+" Adding Luxury car features");
    }
}
public class DecoratorDemo {
    public static void main(String[] args) {
        Car car=new LuxuryCar(new SportsCar(new BasicCar()));
        car.assemble();
    }
}
