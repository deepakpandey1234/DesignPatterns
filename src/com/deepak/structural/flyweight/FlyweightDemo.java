package com.deepak.flyweight;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by panded4 on 9/7/2016.
 * Example: String pool
 */
class Person{
    private String name;
    static ArrayList<Person> persons=null;

    private Person(String name){
        this.name=name;
    }
public String getName(){
    return name;
}
    public static Person getPerson(String name){
        if(persons!=null){
            Iterator<Person> personIterator=persons.iterator();
            while(personIterator.hasNext()){
                Person person=personIterator.next();
                if(person.getName().equals(name)){
                    return person;
                }
            }
        }else{
           persons=new ArrayList<Person>();
        }
        Person p=new Person(name);
        persons.add(p);
        return p;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
//main class
public class FlyweightDemo {
    public static void main(String[] args) {
        Person p1 = Person.getPerson("Hello");
        Person p2 = Person.getPerson("Deepak");
        Person p3 = Person.getPerson("Hello");
        Person p4 = Person.getPerson("Deepak");

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
        System.out.println(p4.hashCode());
    }
}
