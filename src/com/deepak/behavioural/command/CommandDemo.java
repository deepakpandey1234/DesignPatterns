package com.deepak.behavioural.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panded4 on 9/8/2016.
 *Example : Runnable interface
 */
interface Order{
    public void execute();
}
class Stock{
    private String name;
    private int quantity;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    public void buy(){
        System.out.println("Stock.buy");
    }
    public void sell(){
        System.out.println("Stock.sell");
    }
}
//command class
class BuyStock implements Order{
    private Stock xyzStock;

    public BuyStock(Stock xyzStock) {
        this.xyzStock = xyzStock;
    }

    @Override
    public void execute() {
        xyzStock.buy();
    }
}
//command class
class SellStock implements Order{
    private Stock xyzStock;

    public SellStock(Stock xyzStock) {
        this.xyzStock = xyzStock;
    }
    @Override
    public void execute() {
        xyzStock.sell();
    }
}

class Broker{
    private List<Order> list=new ArrayList<>();

    public void takeOrder(Order order){
        list.add(order);
    }
    public void placeOrder(){
        for(Order order:list){
            order.execute();
        }
        list.clear();
    }
}
public class CommandDemo {
    public static void main(String[] args) {
        Broker broker=new Broker();
        broker.takeOrder(new BuyStock(new Stock("SBI",20)));
        broker.takeOrder(new BuyStock(new Stock("Maruti",20)));

        broker.takeOrder(new SellStock(new Stock("Infosys",20)));
        broker.takeOrder(new SellStock(new Stock("TATA",20)));

        broker.placeOrder();
    }
}
