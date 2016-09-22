package com.deepak.composite;

import java.util.*;

/**
 * Created by panded4 on 9/7/2016.
 * Example: Collection with generic, Files and folder
 */
class Employee{
    String name;
    String dept;
    int salary;
    List<Employee> subordinates;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        subordinates = new ArrayList<Employee>();
    }
    public void add(Employee emp){
        subordinates.add(emp);
    }
    public void remove(Employee emp){
        subordinates.remove(emp);
    }
    public List<Employee> getSubordinates(){
        return subordinates;
    }
    public void getSubordinatesDetails(){
        List list=getSubordinates();
        Iterator i=list.iterator();
        while(i.hasNext())
            System.out.println("i = " + i.next());
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
public class CompositeDemo {
    public static void main(String[] args) {
        Employee CEO = new Employee("CEO", "PM", 900000);

        Employee mgr1 = new Employee("Mgr", "Sales", 150000);
        Employee mgr2 = new Employee("Mgr2", "ProM", 150000);

        Employee pr1 = new Employee("Dev", "ECD", 15000);
        Employee pr2 = new Employee("QA", "ECD", 15000);
        Employee pr3 = new Employee("Sr.Engg", "Engg", 15000);
        Employee pr4 = new Employee("Tester", "Engg", 15000);

        mgr1.add(pr1);
        mgr1.add(pr2);
        mgr1.add(pr3);

        mgr2.add(pr1);
        mgr2.add(pr4);

        CEO.add(mgr1);
        CEO.add(mgr2);

        CEO.getSubordinatesDetails();

       // mgr1.getSubordinatesDetails();

        mgr2.getSubordinatesDetails();

    }
}
