package com.deepak.com.deepak.behavioural.strategy;

/**
 * Created by panded4 on 9/8/2016.
 * Example: Sorting based at runtime like insertion/quick/merge which one to choose
 */
interface Strategy {
    int doOperation(int a, int b);
}

class OperationAdd implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a + b;
    }
}

class OperationMul implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a * b;
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calculate(int a, int b) {
        return strategy.doOperation(a, b);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        int result = context.calculate(10, 40);
        System.out.println("result = " + result);
    }
}
