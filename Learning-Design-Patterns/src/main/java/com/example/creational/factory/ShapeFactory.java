package com.example.creational.factory;

public class ShapeFactory extends AbstractFactory{

    @Override
    public Color getColor(String color) {
        return null;
    }

    public Shape getShape(String shapeType){
        Shape shape = null;
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            shape = new Circle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            shape = new Square();
        }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            shape = new Rectangle();
        }
        return shape;
    }
}
