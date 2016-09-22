package com.deepak.behavioural.interpreter;

/**
 * Created by panded4 on 9/8/2016.
 * Example: java.util.pattern
 */
class InterpreterContext{
    public String getBinaryFormat(int i){
        return Integer.toBinaryString(i);
    }
    public String getOctalFormat(int i){
        return Integer.toOctalString(i);
    }
}

interface Expression{
    String interpret(InterpreterContext interpreterContext);
}

class IntToBinary implements Expression{
    private int i;

    public IntToBinary(int i) {
        this.i = i;
    }
    @Override
    public String interpret(InterpreterContext interpreterContext) {
        return interpreterContext.getBinaryFormat(i);
    }
}

class IntToOctal implements Expression{
    private int i;

    public IntToOctal(int i) {
        this.i = i;
    }
    @Override
    public String interpret(InterpreterContext interpreterContext) {
        return interpreterContext.getOctalFormat(i);
    }
}

class InterpreterClient{
    InterpreterContext interpreterContext=null;

    public InterpreterClient(InterpreterContext interpreterContext) {
        this.interpreterContext = interpreterContext;
    }

    public String interpret(String s){
        Expression expression=null;
        if (s.contains("Binary")){
            expression=new IntToBinary(Integer.parseInt(s.substring(0,s.indexOf(" "))));
        }else if(s.contains("Octal")){
            expression=new IntToOctal(Integer.parseInt(s.substring(0,s.indexOf(" "))));
        }else{
            return s;
        }
        return expression.interpret(interpreterContext);
    }
}
public class InterpreterDemo {
    public static void main(String[] args) {
        InterpreterClient interpreterClient=new InterpreterClient(new InterpreterContext());
        System.out.println(args[0]+":"+interpreterClient.interpret(args[0]));
    }
}
