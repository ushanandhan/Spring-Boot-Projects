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

    @Test
    public void builderPatternTest(){
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
        ShapeCache.loadCache();
        com.example.creational.prototype.Shape clonedShape = (com.example.creational.prototype.Shape) ShapeCache.getShape("1");
        System.out.println("Shape : "+clonedShape.getType());

        com.example.creational.prototype.Shape clonedShape1 = (com.example.creational.prototype.Shape) ShapeCache.getShape("2");
        System.out.println("Shape : "+clonedShape1.getType());
    }
}
