package com.example.structural.bridge;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(10,100,100,new RedCircle());
        redCircle.draw();
        Shape greenCircle = new Circle(10,100,100,new GreenCircle());
        greenCircle.draw();
    }
}
