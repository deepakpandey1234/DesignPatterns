package com.deepak.proxy;

/**
 * Created by panded4 on 9/7/2016.
 * Example:
 * Facebook images
 * stub
 * java.lang.reflect.Proxy
 *java.rmi.*
 *javax.ejb.EJB (explanation here)
 *javax.inject.Inject (explanation here)
 *javax.persistence.PersistenceContext
 */
interface Image{
     void display();
}

class RealImage implements Image{
    private String fileName;
    public RealImage(String fileName){
        this.fileName=fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading file from Disk:"+fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying:"+fileName);
    }
}

class ProxyImage implements Image{
    private RealImage realImage=null;
    private String fileName;
    public ProxyImage(String fileName){
        this.fileName=fileName;
    }
    @Override
    public void display() {
       if(realImage==null){
           realImage=new RealImage(fileName);
       }
        realImage.display();
    }
}
//main class
public class ProxyDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("deepak.txt");
        image.display();
        image.display();
        image.display();
    }
}
