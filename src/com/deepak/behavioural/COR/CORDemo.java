package com.deepak.behavioural.COR;

interface DispenseChain {
    public void dispense(Currency currency);

    public void setNext(DispenseChain dispenseChain);
}

/**
 * Created by panded4 on 9/7/2016.
 * Example : ExceptionHandling
 * java.util.logging.Logger#log()
 * javax.servlet.Filter#doFilter()
 */
class Currency {
    private int amount;

    public Currency(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}

class Rupee1000 implements DispenseChain {
    DispenseChain chain;

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 1000) {
            int num = currency.getAmount() / 1000;
            int rem = currency.getAmount() % 1000;
            System.out.println("Dispensing:" + num + " notes of Rs.1000");
            if (rem != 0)
                chain.dispense(new Currency(rem));
        } else {
            chain.dispense(currency);
        }
    }

    @Override
    public void setNext(DispenseChain dispenseChain) {
        chain = dispenseChain;
    }
}

class Rupee500 implements DispenseChain {
    DispenseChain chain;

    @Override
    public void dispense(Currency currency) {
        int num, rem = 0;
        if (currency.getAmount() >= 500) {
            num = currency.getAmount() / 500;
            rem = currency.getAmount() % 500;
            System.out.println("Dispensing:" + num + " notes of Rs.500");
            if (rem != 0)
                chain.dispense(new Currency(rem));
        } else {
            chain.dispense(currency);
        }
    }

    @Override
    public void setNext(DispenseChain dispenseChain) {
        chain = dispenseChain;
    }
}

class Rupee100 implements DispenseChain {
    DispenseChain chain;

    @Override
    public void dispense(Currency currency) {
        int num, rem = 0;
        if (currency.getAmount() >= 100) {
            num = currency.getAmount() / 100;
            rem = currency.getAmount() % 100;
            System.out.println("Dispensing:" + num + " notes of Rs.100");
            if (rem != 0)
                chain.dispense(new Currency(rem));
        } else {
            chain.dispense(currency);
        }
    }

    @Override
    public void setNext(DispenseChain dispenseChain) {
        chain = dispenseChain;
    }
}

class ATMDispenser {
    DispenseChain dispenseChain;

    public ATMDispenser() {
        dispenseChain = new Rupee1000();
        DispenseChain dispenseChain1 = new Rupee500();
        DispenseChain dispenseChain2 = new Rupee100();

        dispenseChain.setNext(dispenseChain1);
        dispenseChain1.setNext(dispenseChain2);
    }
}

//main class
public class CORDemo {
    public static void main(String[] args) {
        ATMDispenser atmDispenser = new ATMDispenser();
        atmDispenser.dispenseChain.dispense(new Currency(Integer.parseInt(args[0])));
    }
}
