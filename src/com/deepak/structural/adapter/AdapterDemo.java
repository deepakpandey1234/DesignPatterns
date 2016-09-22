package com.deepak.adapter;

/**
 * Created by panded4 on 9/7/2016.
 * Abstarct design patterns
 * Example: Integer-int
 */
class Volt{
    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }

    private int volts;
    public Volt(int v){
        volts=v;
    }
}
class Socket{
    public Volt getVolt(){
        return new Volt(220);
    }
}
interface SocketAdapter{
    public Volt get10Volts();
    public Volt get240Volts();
}
//class based implementation
class SocketClassAdapterImpl extends Socket implements SocketAdapter{
    @Override
    public Volt get10Volts() {
        Volt v=getVolt();
        return convertVolt(v,22);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts()/i);
    }

    @Override
    public Volt get240Volts() {
        return getVolt();
    }
}
//association based implementation
//consider Socket is abstarct /final so can't be overriden
class SocketObjectAdapterImpl implements SocketAdapter{

//create object
Socket socket=new Socket();
    @Override
    public Volt get10Volts() {
        Volt v=socket.getVolt();
        return convertVolt(v,22);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts()/i);
    }

    @Override
    public Volt get240Volts() {
        return socket.getVolt();
    }
}
//main class
public class AdapterDemo {
    public static void main(String[] args) {
       // SocketAdapter adapter=new SocketClassAdapterImpl();
        SocketAdapter adapter=new SocketObjectAdapterImpl();

        Volt v1=adapter.get10Volts();
        Volt v2=adapter.get240Volts();

        System.out.println("v1 = " + v1.getVolts());
        System.out.println("v2 = " + v2.getVolts());
    }
}