/*
package com.deepak.behavioural.visitor;

*/
/**
 * Created by panded4 on 9/8/2016.
 * Example : Garbage collection mark-sweep
 * javax.lang.model.element.AnnotationValue and AnnotationValueVisitor
 * javax.lang.model.element.Element and ElementVisitor
 * javax.lang.model.type.TypeMirror and TypeVisitor
 * java.nio.file.FileVisitor and SimpleFileVisitor
 * javax.faces.component.visit.VisitContext and VisitCallback
 *//*

interface ComputerPartVisitor {
    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);

    void visit(Motherboard motherboard);
}

abstract class ComputerPart {
    int price;

    public abstract void accept(ComputerPartVisitor computerPartVisitor);
}

class Keyboard extends ComputerPart {
    public Keyboard(int p) {
        price = p;
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

class Monitor extends ComputerPart {
    public Monitor(int p) {
        price = p;
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

class Motherboard extends ComputerPart {
    public Motherboard(int p) {
        price = p;
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
        //for(int )
    }
}

class Mouse extends ComputerPart {
    public Mouse(int p) {
        price = p;
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Mouse mouse) {
        System.out.println("ComputerPartDisplayVisitor.visit");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("ComputerPartDisplayVisitor.visit");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("ComputerPartDisplayVisitor.visit");
    }

    @Override
    public void visit(Motherboard motherboard) {
        System.out.println("ComputerPartDisplayVisitor.visit");
    }
}
class Computer extends ComputerPart{
    ComputerPart parts[];

    public Computer() {
        parts = new ComputerPart[]{new Mouse(300),new Motherboard(5000),new Keyboard(600),new Monitor(5000)};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
computerPartVisitor.visit(this);


    }
}
public class VisitorDemo {
    public static void main(String[] args) {

    }
}
*/
