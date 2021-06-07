package com.example.creational.factory;

public class ColorFactory extends AbstractFactory{
    @Override
    public Color getColor(String colorType) {
        Color color = null;
        if(colorType.equalsIgnoreCase("RED")){
            color = new Red();
        }else if(colorType.equalsIgnoreCase("GREEN")){
            color = new Green();
        }else if(colorType.equalsIgnoreCase("BLUE")){
            color = new Blue();
        }
        return color;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
