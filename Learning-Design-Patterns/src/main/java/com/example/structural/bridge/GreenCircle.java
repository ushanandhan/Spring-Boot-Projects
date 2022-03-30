package com.example.structural.bridge;

public class GreenCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing green circle with Radius : "+radius+", x : "+x+", y :"+y);
    }
}
