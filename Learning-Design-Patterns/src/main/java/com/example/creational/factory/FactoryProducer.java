package com.example.creational.factory;

public class FactoryProducer {

    public static AbstractFactory getFactory(String choice){
        AbstractFactory factory = null;
        if(choice.equalsIgnoreCase("SHAPE")){
            factory = new ShapeFactory();
        }else if(choice.equalsIgnoreCase("COLOR")){
            factory = new ColorFactory();
        }
        return factory;
    }
}
