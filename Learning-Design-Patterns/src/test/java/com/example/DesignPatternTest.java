package com.example;

import com.example.creational.factory.*;
import com.example.creational.singleton.SingletonObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DesignPatternTest {

    @Test
    public void factoryPatternTest(){
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();
        Shape shape3 = shapeFactory.getShape("RECTANGLE");
        shape3.draw();
    }

    @Test
    public void abstractFactoryPatternTest(){
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        Shape shape = shapeFactory.getShape("CIRCLE");
        shape.draw();
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color color = colorFactory.getColor("RED");
        color.fill();
    }

    @Test
    public void singletonPatternTest(){
        SingletonObject object = SingletonObject.getInstance();
        System.out.println(object);
        SingletonObject object1 = SingletonObject.getInstance();
        System.out.println(object1);
        assertTrue(object.equals(object1));
    }
}
