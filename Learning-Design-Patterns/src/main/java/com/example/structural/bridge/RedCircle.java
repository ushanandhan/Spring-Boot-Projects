package com.example.structural.bridge;

public class RedCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing red circle with Radius : "+radius+", x : "+x+", y : "+y);
    }
}
