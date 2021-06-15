package com.example;

import com.example.creational.builder.Meal;
import com.example.creational.builder.MealBuilder;
import com.example.creational.factory.*;
import com.example.creational.prototype.ShapeCache;
import com.example.creational.singleton.SingletonObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DesignPatternTest {

    @Test
    public void factoryPatternTest(){
        /**
         * In Factory pattern, we create object without exposing the creation logic to the client and refer to newly
         * created object using a common interface.
         */
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
        /**
         * In Abstract Factory pattern an interface is responsible for creating a factory of related objects without
         * explicitly specifying their classes. Each generated factory can give the objects as per the Factory pattern.
         */
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        Shape shape = shapeFactory.getShape("CIRCLE");
        shape.draw();
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color color = colorFactory.getColor("RED");
        color.fill();
    }

    @Test
    public void singletonPatternTest(){
        /**
         * This pattern involves a single class which is responsible to create an object while making sure that only
         * single object gets created. This class provides a way to access its only object which can be accessed
         * directly without need to instantiate the object of the class.
         */
        SingletonObject object = SingletonObject.getInstance();
        System.out.println(object);
        SingletonObject object1 = SingletonObject.getInstance();
        System.out.println(object1);
        assertTrue(object.equals(object1));
    }

    @Test
    public void builderPatternTest(){
        /**
         * Builder pattern builds a complex object using simple objects and using a step by step approach.
         */
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal Details :");
        vegMeal.showItems();
        System.out.println("Total cost is : "+vegMeal.getPrice());
        System.out.println("===========================================");
        Meal nonVegMeal = mealBuilder.prepareChickenMeal();
        System.out.println("Non Veg Meal Details");
        nonVegMeal.showItems();
        System.out.println("Total cost is : "+nonVegMeal.getPrice());
    }

    @Test
    public void prototypePatternTest() throws CloneNotSupportedException {
        /**
         * Prototype pattern refers to creating duplicate object while keeping performance in mind.
         */
        ShapeCache.loadCache();
        com.example.creational.prototype.Shape clonedShape = (com.example.creational.prototype.Shape) ShapeCache.getShape("1");
        System.out.println("Shape : "+clonedShape.getType());

        com.example.creational.prototype.Shape clonedShape1 = (com.example.creational.prototype.Shape) ShapeCache.getShape("2");
        System.out.println("Shape : "+clonedShape1.getType());
    }


}
